package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Persona;
import model.Persone;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MostraListaController extends HomeController implements Initializable {

    @FXML private TableView<Persona> tableView;
    @FXML private TableColumn<Persona, String> nomeColumn;
    @FXML private TableColumn<Persona, String> cognomeColumn;
    @FXML private TableColumn<Persona, String> numeroColumn;
    @FXML private TableColumn<Persona, String> prenotazioneColumn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomeColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("nome"));
        cognomeColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("cognome"));
        numeroColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("numero"));
        prenotazioneColumn.setCellValueFactory(new PropertyValueFactory<Persona, String>("prenotazioneString"));

        if(Persone.getPersone()!=null) {
            int size = Persone.getSize();
            ArrayList<Persona> personeAL;
            personeAL = Persone.getPersone();

            for (int i = 0; i < size; i++) {
                Persona persona = personeAL.get(i);
                ObservableList<Persona> personeOL = tableView.getItems();
                personeOL.add(persona);
                tableView.setItems(personeOL);
            }
        }
    }
}