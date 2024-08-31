package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.PassaEvento;


import java.io.IOException;
import java.util.Objects;

public class LogoutController extends HomeController{

    public void logoutYes(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Login.fxml")));
        stage = (Stage) ((Node) PassaEvento.getEvent().getSource()).getScene().getWindow();
        stage.hide();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(652);
        stage.setY(200);
        stage.setTitle("Gestionale Discotyeca");
        stage.getIcons().add(new Image("presentation/img/logo2.png"));
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    public void logoutNo(ActionEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
    }
}
