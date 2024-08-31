package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import model.Persone;

public class GestisciEntrataController extends HomeController implements Initializable {

    @FXML
    private ComboBox<String> hourBox;
    @FXML
    private ComboBox<String> dressBox;

    @FXML
    private TextField phoneField;
    @FXML
    private TextField yearsField;

    @FXML
    private Label checkLabel;

    ObservableList<String> list1 = FXCollections.observableArrayList("Elegante", "Tuta");
    ObservableList<String> list2 = FXCollections.observableArrayList("1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00");

    private String phone;
    private int years;
    private int hour;
    private boolean dress;
    private String temp;
    private String temp2;

    private int temp3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dressBox.setItems(list1);
        hourBox.setItems(list2);
    }

    public void submit(ActionEvent actionEvent) {
        if(phoneField.getText().isBlank() || yearsField.getText().isBlank() || hourBox.getValue()==null || dressBox.getValue()==null)
            checkLabel.setText("Riempi tutti i campi");
        else {
            if (isNumeric(yearsField.getText()) && isNumeric(phoneField.getText())) {
                years = Integer.parseInt(yearsField.getText());
                phone = phoneField.getText();
                temp2 = dressBox.getValue();
                if (temp2.equals("Elegante")) {
                    dress = true;
                } else {
                    dress = false;
                }
                temp = hourBox.getValue();
                if (temp.equals("22:00") || temp.equals("23:00") || temp.equals("24:00") || temp.equals("1:00") || temp.equals("2:00") || temp.equals("3:00") || temp.equals("4:00")) {
                    hour = 1; //entra pagando
                    if (temp.equals("2:00") || temp.equals("3:00")) {
                        hour = 0; //entra gratis
                    }
                } else {
                    hour = -1; //non entra
                }

                temp3 = Persone.gestisciEntrata(phone, years, dress, hour);
                if (temp3 == -2) {
                    checkLabel.setText("La prenotazione non è stata trovata");
                } else if (temp3 == -1) {
                    checkLabel.setText("Non può entrare");
                } else if (temp3 == 0) {
                    checkLabel.setText("Può entrare gratis");
                } else {
                    checkLabel.setText("Può entrare, sono " + temp3 + "€");
                }
            } else {
                checkLabel.setText("Inserisci un numero in 'anni' e 'numero'");
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