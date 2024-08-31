package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import model.Persone;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CercaController extends HomeController implements Initializable {

    @FXML private TextField nome;
    @FXML private TextField cognome;
    @FXML private TextField numero;
    @FXML private Label reservationLabel;
    @FXML private Label reservationLabel2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public int searchNC(ActionEvent event) {
        if(nome.getText().isBlank() || cognome.getText().isBlank()) {
            reservationLabel.setAlignment(Pos.CENTER);
            reservationLabel.setText("Riempi tutti i campi");
        }
        else {
            for (int i = 0; i < Persone.getSize(); i++) {
                if (Objects.equals(Persone.getPersone().get(i).getNome(), nome.getText()))
                    if (Objects.equals(Persone.getPersone().get(i).getCognome(), cognome.getText())) {
                        nome.clear();
                        cognome.clear();
                        return fullApp(i, reservationLabel);
                    }
            }
            reservationLabel.setAlignment(Pos.CENTER);
            reservationLabel.setText("Nessuna prenotazione trovata");
        }
        return 0;
    }


    public int searchT(ActionEvent event) {
        if(numero.getText().isBlank()) {
            reservationLabel2.setAlignment(Pos.CENTER);
            reservationLabel2.setText("Riempi il campo");
        }
        else {
            for (int i = 0; i < Persone.getSize(); i++) {
                if (Objects.equals(Persone.getPersone().get(i).getNumero(), numero.getText())){
                    numero.clear();
                    return fullApp(i, reservationLabel2);
                }
            }
            reservationLabel2.setAlignment(Pos.CENTER);
            reservationLabel2.setText("Nessuna prenotazione trovata");
        }
        return 0;
    }


    public int fullApp(int i, Label reservationLabel) {
        reservationLabel.setAlignment(Pos.TOP_LEFT);
        String app = "Nome: "+ Persone.getPersone().get(i).getNome()+"\n";
        app += "Cognome: "+Persone.getPersone().get(i).getCognome()+"\n";
        app += "Telefono: "+Persone.getPersone().get(i).getNumero()+"\n";
        app += "Tipo prenotazione: "+Persone.getPersone().get(i).getPrenotazioneString();
        reservationLabel.setText(app);
        return 1;
    }
}