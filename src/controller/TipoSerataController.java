package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Discoteca;

import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TipoSerataController extends HomeController implements Initializable {
    @FXML private TextField nuovoTipo;
    @FXML private Label reservationLabel;
    @FXML private Label reservationLabelError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Discoteca.getTipoMusica()==null)
            reservationLabel.setText("Non selezionato");
        else
            reservationLabel.setText(Discoteca.getTipoMusica());
    }

    public void cambiaTipo(ActionEvent event) {
        if(nuovoTipo.getText().isBlank())
            reservationLabelError.setText("Riempi il campo");
        else{
            reservationLabelError.setText("");
            reservationLabel.setText(nuovoTipo.getText());
            Discoteca.setTipoMusica(nuovoTipo.getText());
            nuovoTipo.setText("");
        }
    }
}
