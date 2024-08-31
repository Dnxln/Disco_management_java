package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import model.Persone;

import javax.swing.text.html.ImageView;

public class AggiungiController extends HomeController implements Initializable {
    @FXML
    private ComboBox<String> reservationBox;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField phoneField;

    @FXML
    private Label reservationLabel;


    private static String name;
    private static String surname;
    private static String phone;


    private String temp;
    private static int reservation;


    ObservableList<String> list = FXCollections.observableArrayList("Maschio", "Femmina", "Tavolo con bottiglia", "Tavolo senza bottiglia");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservationBox.setItems(list);
    }

    public void submit(javafx.event.ActionEvent actionEvent) throws Exception {
        name = nameField.getText();
        surname = surnameField.getText();
        phone = phoneField.getText();

        temp = reservationBox.getValue();
        if(temp != null) {
            if(temp.equals("Femmina")){
                reservation = 0;
            }
            else if(temp.equals("Maschio")){
                reservation = 1;
            }
            else if(temp.equals("Tavolo senza bottiglia")){
                reservation = 2;
            }
            else{
                reservation  = 3;
            }
        }

        if(name.isBlank() || surname.isBlank() || phone.isBlank()) {
            reservationLabel.setText("Riempi tutti i campi");
        }
        else if(!isNumeric(phoneField.getText())){
            reservationLabel.setText("Inserisci un numero nel campo \"Numero di telefono\" ");
        }
        else {
            if(temp != null){
                reservationLabel.setText("Prenotazione aggiunta");
                Persone.add(name, surname, phone, reservation);
                nameField.clear();
                surnameField.clear();
                phoneField.clear();
                reservationBox.valueProperty().set(null);
            }
            else{
                reservationLabel.setText("Riempi tutti i campi");
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}