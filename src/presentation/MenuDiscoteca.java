package presentation;
import model.*;
import files.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDiscoteca {
    public static void menu() {
        int scelta = 0;
        String pathFile = "discoteca.bin";

        String nome;
        String cognome;
        String telefono;
        int eta;
        int temp;
        boolean outfit;
        String tipoMusica;
        int ora;
        int entrata;
        Persona p;

        Discoteca d = new Discoteca("Non impostato");

        try {
            d = (Discoteca) GestioneFileBinari.caricaDati(pathFile);
            System.out.println("E' stata caricata la lista dal file con successo");
        } catch (Exception e) {
            System.out.println("Non e' stata trovata alcuna lista");
            //e.printStackTrace();
        }



        do {
            System.out.println("+-----------------------------------------------------------------------------------+");
            System.out.println("|1) Aggiungi una prenotazione                                                       |");
            System.out.println("|2) Cancella una prenotazione dato nome e cognome                                   |");
            System.out.println("|3) Cancella una prenotazione dato il numero                                        |");
            System.out.println("|4) Cerca una prenotazione dato nome e cognome                                      |");
            System.out.println("|5) Cerca una prenotazione dato il numero                                           |");
            System.out.println("|6) Mostra tutte le prenotazioni della serata (prima tavoli)                        |");
            System.out.println("|7) Gestisci entrata fuori dal locale (tipo buttafuori) (la lista rimane invariata) |");
            System.out.println("|8) Cambia tipo della serata (es: techno, raggaeton...)                             |");
            System.out.println("|0) Salva e esci                                                                    |");
            System.out.println("+-----------------------------------------------------------------------------------+");
            System.out.println("|                                Scegli cosa fare                                   |");
            System.out.println("+-----------------------------------------------------------------------------------+");
            scelta = InputTastiera.leggiInt("\n");

            switch (scelta){
                case 0: //Salva e esci
                    try {
                        GestioneFileBinari.salvaDati(d, pathFile);
                        System.out.println("Il salvataggio e' andato a buon fine");
                    } catch (Exception e) {
                        System.out.println("Il salvataggio non e' andato a buon fine");
                    }
                    finally {
                        System.out.println("Programma chiuso");
                    }
                    break;

                case 1: //Aggiungi una prenotazione
                    int prenotazione = 0;
                    nome = InputTastiera.leggiString("Nome: ");
                    cognome = InputTastiera.leggiString("Cognome: ");
                    telefono = InputTastiera.leggiString("Numero di telefono: ");
                    do {
                        prenotazione = InputTastiera.leggiInt("Tipo di prenotazione: \n0) Femmina\n1) Maschio\n2) Tavolo no bottiglia\n3) Tavolo con bottiglia");
                    }
                    while(!(prenotazione >= 0 && prenotazione <= 3));
                    d.setPersona(telefono, new Persona(nome, cognome, telefono, prenotazione));
                    System.out.println("La prenotazione è stata aggiunta con successo");
                    break;

                case 2: //Cancella una prenotazione dato nome e cognome
                    nome = InputTastiera.leggiString("Nome: ");
                    cognome = InputTastiera.leggiString("Cognome: ");

                    if(d.rimuoviPersona(nome, cognome) != null) {
                        System.out.println("La prenotazione e' stata rimossa con successo");
                    }
                    else {
                        System.out.println("La prenotazione non e' stata rimossa/trovata");
                    }
                    break;

                case 3: //Cancella una prenotazione dato il numero
                    String numero = InputTastiera.leggiString("Numero: ");

                    if(d.rimuoviPersona(numero) != null) {
                        System.out.println("La prenotazione e' stata rimossa con successo");
                    }
                    else {
                        System.out.println("La prenotazione non e' stata rimossa/trovata");
                    }
                    break;

                case 4: //Cerca una prenotazione dato nome e cognome
                    nome = InputTastiera.leggiString("Nome: ");
                    cognome = InputTastiera.leggiString("Cognome: ");
                    p = d.cercaPersonaNome(nome, cognome);
                    if(p != null) {
                        System.out.println(p.toString());
                    }
                    else {
                        System.out.println("Persona non trovata");
                    }
                    break;

                case 5: //Cerca una prenotazione dato il numero
                    telefono = InputTastiera.leggiString("Telefono: ");
                    p = d.cercaPersonaTelefono(telefono);
                    if(p != null) {
                        System.out.println(p.toString());
                    }
                    else {
                        System.out.println("Persona non trovata");
                    }
                    break;

                case 6: //Mostra tutte le prenotazioni della serata (prima tavoli)
                    System.out.println("Tipo della serata + Lista ordinata:");
                    System.out.println(d.toString());
                    System.out.println("----------------------------------------------\nlegenda prenotazione: 0=femmina \n                      1=maschio \n                      2=tavolo no bottiglia \n                      3=tavolo con bottliglia \n----------------------------------------------");
                    break;

                case 7: //Gestisci entrata fuori dal locale (tipo buttafuori) (la lista rimane invariata)
                    telefono = InputTastiera.leggiString("Dammi il numero della prenotazione (numero di telefono): ");
                    eta = InputTastiera.leggiInt("Quanti anni hai? ");
                    ora = InputTastiera.leggiInt("Che ore sono? ");

                    do {
                        System.out.println("Come è vestito? \n1) Tuta\n2) Elegante");
                        temp = InputTastiera.leggiInt();
                    }
                    while(!(temp > 0 && temp < 3));
                    if(temp == 1) {
                        outfit = false;
                    }
                    else {
                        outfit = true;
                    }
                    if(d.cercaPersonaTelefono(telefono) != null) {

                        entrata = d.controlloEntrata(eta, outfit, ora, d.cercaPersonaTelefono(telefono));
                        if(entrata == -1) {

                            System.out.println("Non puoi entrare");
                        }
                        else {
                            System.out.println("Puoi entrare, sono: " + entrata + " euro");
                        }
                    }
                    else {
                        System.out.println("Prenotazione non trovata");
                    }
                    break;

                case 8: //Cambia tipo della serata (es: techno, raggaeton...)
                    tipoMusica = InputTastiera.leggiString("Inserisci il tipo di musica della discoteca: ");
                    d.setTipoMusica(tipoMusica);
                    break;
            }
        }
        while(scelta != 0);
    }

    private static void palle() {

    }
}
