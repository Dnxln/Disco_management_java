package model;

import files.GestioneFileBinari;
import javafx.stage.Stage;
import presentation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Discoteca implements Serializable {
    //Attributi
    private static String tipoMusica;
    private HashMap<String, Persona> persone;
    private static final int prezzoMaschio = 20;
    private static final int prezzoFemmina = 15;
    private static final int prezzoTavolo = 35;
    private static final int prezzoTavoloBottiglia = 50;

    //Costruttore
    public Discoteca(String tipoMusica) {
        this.persone = new HashMap<String, Persona>();
        this.tipoMusica = tipoMusica;
    }

    //Get e set
    public static String getTipoMusica() {
        return tipoMusica;
    }
    public static void setTipoMusica(String tipoMusica) {
        Discoteca.tipoMusica = tipoMusica;
    }
    public HashMap<String, Persona> getPersone() {
        return persone;
    }
    public void setPersone(HashMap<String, Persona> persone) {
        this.persone = persone;
    }

    //Metodi
    //Aggiungi persona
    public void setPersona(String numero, Persona p) {
        persone.put(numero, p);
    }

    //Rimuovi persona dato numero
    public Persona rimuoviPersona(String numero) {
        if(persone.get(numero) != null) {
            Persona temp = persone.get(numero);
            persone.remove(numero);
            return temp;
        }
        return null;
    }

    //Rimuovi persona dato nome e cognome
    public Persona rimuoviPersona(String nome, String cognome) {
        if(cercaPersonaNome(nome, cognome) != null) {
            Persona temp = cercaPersonaNome(nome, cognome);
            persone.remove(temp.getNumero());
            return temp;
        }
        return null;
    }

    //Cerca persona dato numero telefonico 												(?)
    public Persona cercaPersonaTelefono(String numero) {
        Collection<Persona> temp2 = persone.values();
        for(Persona p: temp2) {
            if(p.getNumero().equals(numero)) {
                return persone.get(numero);
            }
        }
        return null;
    }

    //Cerca persona tramite nome e cognome
    public Persona cercaPersonaNome(String nome, String cognome) {
        Collection<Persona> temp2 = persone.values();
        for(Persona p: temp2) {
            if(p.getNome().equals(nome) && p.getNome().equals(cognome)) {
                return p;
            }
        }
        return null;
    }

    //controllo all'entrata che richiama tutti gli altri controlli
    public int controlloEntrata(int eta, boolean outfit, int ora, Persona p) {
        if(controllaMaggiorenne(eta) == true && controllaOutfit(outfit) == true) {
            if(controllaOra(ora) == -1) {
                return -1;
            }
            else if(controllaOra(ora) == 0) {
                return 0;
            }
            else {
                if(p.getPrenotazione() == 0) {
                    return prezzoFemmina;
                }
                else if(p.getPrenotazione() == 1) {
                    return prezzoMaschio;
                }
                else if(p.getPrenotazione() == 2) {
                    return prezzoTavolo;
                }
                else if(p.getPrenotazione() == 3) {
                    return prezzoTavoloBottiglia;
                }
            }

        }
        return -1;
    }

    //Controlla se è maggiorenne
    public boolean controllaMaggiorenne(int eta) {
        if(eta >= 18) {
            return true;
        }
        return false;

    }

    //Controlla outfit
    public boolean controllaOutfit(boolean outfit) { // 1=true vestito 2=false maranza
        if(outfit) {
            return true;
        }
        return false;
    }

    //Controlla orario
    public int controllaOra(int ora) { //alle 22 apre, alle 4 chiude, quindi chiunque voglia entrare dopo le 22 (comprese) e prima delle 4 (non comprese) può farlo
        String ora2 = String.valueOf(ora);
        if(ora2.equals("22") || ora2.equals("23") || ora2.equals("24") || ora2.equals("1") || ora2.equals("0") || ora2.equals("2") || ora2.equals("3")) {
            if(ora2.equals("2") || ora2.equals("3")) {
                return 0; //entra gratis
            }
            return 1; //entra pagando
        }
        return -1; //non entra
    }

    //Stampa lista contatti
    //toString con priorità
    public String toString() {
        String temp = "";
        temp += "Tipo discoteca: [tipoMusica=" + tipoMusica + "]\n\n";
        Collection<Persona> temp2 = persone.values();
        for(Persona p : temp2) {
            if(p.getPrenotazione() == 2 || p.getPrenotazione() == 3 ) {
                temp += p.toString()+"\n";
            }
        }
        for(Persona p : temp2) {
            if(p.getPrenotazione() == 0 || p.getPrenotazione() == 1 ) {
                temp += p.toString()+"\n";
            }
        }
        return temp;
    }
}