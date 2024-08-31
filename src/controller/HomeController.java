package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.PassaEvento;

import java.io.IOException;
import java.util.Objects;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private javafx.scene.control.Button btnAdd;
    @FXML private javafx.scene.control.Button btnDel;
    @FXML private javafx.scene.control.Button btnSea;
    @FXML private javafx.scene.control.Button btnSho;
    @FXML private javafx.scene.control.Button btnMan;
    @FXML private javafx.scene.control.Button btnTyp;
    @FXML private javafx.scene.control.Button btnLog;

    public void home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Home.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void aggiungi(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Aggiungi.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void cancella(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Cancella.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void cerca(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Cerca.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void mostraLista(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/MostraLista.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gestisciEntrata(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/GestisciEntrata.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void tipoSerata(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/TipoSerata.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent logoutReq = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Logout.fxml")));
        stage.setTitle("Logout");
        final Popup popup = new Popup();
        popup.show(stage);
        stage.setScene(new Scene(logoutReq));
        PassaEvento.setEvent(event);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public void hoverAdd(MouseEvent mouseEvent) {
        btnAdd.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverAdd(MouseEvent mouseEvent) {
        btnAdd.setStyle("-fx-background-color: #313135; ");
    }

    public void hoverDel(MouseEvent mouseEvent) {
        btnDel.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverDel(MouseEvent mouseEvent) {
        btnDel.setStyle("-fx-background-color: #313135; ");
    }

    public void hoverSea(MouseEvent mouseEvent) {
        btnSea.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverSea(MouseEvent mouseEvent) {
        btnSea.setStyle("-fx-background-color: #313135; ");
    }

    public void hoverSho(MouseEvent mouseEvent) {
        btnSho.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverSho(MouseEvent mouseEvent) {
        btnSho.setStyle("-fx-background-color: #313135; ");
    }

    public void hoverMan(MouseEvent mouseEvent) {
        btnMan.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverMan(MouseEvent mouseEvent) {
        btnMan.setStyle("-fx-background-color: #313135; ");
    }

    public void hoverTyp(MouseEvent mouseEvent) {
        btnTyp.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverTyp(MouseEvent mouseEvent) {
        btnTyp.setStyle("-fx-background-color: #313135; ");
    }

    public void hoverLog(MouseEvent mouseEvent) {btnLog.setStyle("-fx-background-color: #4a4a4f; ");
    }

    public void notHoverLog(MouseEvent mouseEvent) {btnLog.setStyle("-fx-background-color: #313135; ");
    }

}