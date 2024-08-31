package model;


import files.GestioneFileBinari;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Persone {
    private static ArrayList<Persona> persone = new ArrayList<>();
    String pathFile = "tipoMusica.bin";

    public static void add(String nome, String cognome, String telefono, int prenotazione) throws Exception {
        persone.add(new Persona(nome,cognome,telefono, prenotazione));
    }

    public static boolean remove(String name, String surname) {
        for(int i = 0; i < persone.size(); i++){
            if(persone.get(i).getNome().equals(name) && persone.get(i).getCognome().equals(surname)) {
                persone.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean remove(String phone) {
        for(int i = 0; i < persone.size(); i++){
            if(persone.get(i).getNumero().equals(phone)) {
                persone.remove(i);
                return true;
            }
        }
        return false;
    }

    public static int gestisciEntrata(String phone, int years, boolean dress, int hour) { //-2 prenotazione non trovata -1 non può entrare, 0 entra gratis, n entra pagando n
        for(int i = 0; i < persone.size(); i++){
            if(persone.get(i).getNumero().equals(phone)) {
                if(years >= 18) {
                    if(dress) {
                        if(hour == 1) {
                            int reservation = persone.get(i).getPrenotazione();
                            if (reservation == 0){ //0=15 / 1=20 / 2=35 / 3=50
                                return 15;
                            }
                            else if (reservation == 1) {
                                return 20;
                            }
                            else if (reservation == 2) {
                                return 35;
                            }
                            else {
                                return 50;
                            }
                        }
                        else if (hour == 0) {
                            return 0;
                        }
                        else {
                            return -1;
                        }
                    }
                    else {
                        return -1;
                    }
                }
                else{
                    return -1;
                }
            }
        }
        return -2;
    }

    public static void onOpen(String pathFileP, String pathFileM){
        try {
            persone = (ArrayList<Persona>) GestioneFileBinari.caricaDati(pathFileP);
            //System.out.println("E' stata caricata la lista dal file con successo");


            Discoteca.setTipoMusica((String) GestioneFileBinari.caricaDati(pathFileM));
            //System.out.println("E' stato caricato il tipo musica");
        }
        catch (Exception e) {
            persone = new ArrayList<>();
            //System.out.println("Non e' stata trovata alcuna lista");


            //System.out.println("Non è stato caricato il tipo musica");
        }
    }

    public static void onClose(Stage stage, String pathFileP, String pathFileM){
        stage.setOnCloseRequest(event -> {
            try {
                GestioneFileBinari.salvaDati(persone, pathFileP);
                //System.out.println("E' stata salvata la lista dal file con successo");


                GestioneFileBinari.salvaDati(Discoteca.getTipoMusica(), pathFileM);
                //System.out.println("E' stato salvato il tipo musica ");
            } catch (Exception e) {
                //throw new RuntimeException(e);ù
                //System.out.println("Non è stata salvata la lista dal file con successo");


                //System.out.println("Non è stato salvato il tipo musica");
            }
        });
    }


    public static ArrayList<Persona> getPersone() {
        return persone;
    }

    public static int getSize(){
        return persone.size();
    }
}
