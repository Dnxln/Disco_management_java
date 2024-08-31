package model;

import java.io.Serializable;

public class Persona implements Serializable {
    //Attributi
    private String nome;
    private String cognome;
    private String numero;
    private int prenotazione; // 0=donna / 1=uomo / 2=tavolo no bottiglia / 3=tatvolo e bottiglia
    private String prenotazioneString;

    //Costruttore
    public Persona(String nome, String cognome, String numero, int prenotazione) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.prenotazione = prenotazione;
        if(this.prenotazione==0) this.prenotazioneString="Femmina";
        else if(this.prenotazione==1) this.prenotazioneString="Maschio";
        else if(this.prenotazione==2) this.prenotazioneString="Tavolo senza bottiglia";
        else if(this.prenotazione==3) this.prenotazioneString="Tavolo con bottiglia";
    }

    //Get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public int getPrenotazione() {
        return prenotazione;
    }
    public void setPrenotazione(int prenotazione) {
        this.prenotazione = prenotazione;
    }

    public void setPrenotazioneString(String prenotazioneString) {
        this.prenotazioneString = prenotazioneString;
    }

    public String getPrenotazioneString() {
        return prenotazioneString;
    }

    //toString
    public String toString() {
        return "Persona [nome=" + nome + ", cognome=" + cognome + ", numero=" + numero + ", prenotazione=" + prenotazione + "]";
    }
}