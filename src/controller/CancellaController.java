package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Persone;

public class CancellaController extends HomeController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField phoneField;

    @FXML
    private Label reservationLabel1;
    @FXML
    private Label reservationLabel2;

    private String name;
    private String surname;
    private String phone;


    public void submit1(ActionEvent actionEvent) {
        name = nameField.getText();
        surname = surnameField.getText();

        if(name.isBlank() || surname.isBlank()) {
            reservationLabel1.setText("Riempi tutti i campi");
        }
        else {
            if(Persone.remove(name, surname)) {
                reservationLabel1.setText("Prenotazione cancellata");
                nameField.clear();
                surnameField.clear();
            }
            else{
                reservationLabel1.setText("Prenotazione non trovata");
            }
        }
    }

    public void submit2(ActionEvent actionEvent) {
        phone = phoneField.getText();

        if(phone.isBlank()) {
            reservationLabel2.setText("Riempi tutti i campi");
        }
        else {
            if(Persone.remove(phone)) {
                reservationLabel2.setText("Prenotazione cancellata");
                phoneField.clear();
            }
            else{
                reservationLabel2.setText("Prenotazione non trovata");
            }
        }
    }
}