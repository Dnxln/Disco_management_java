package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class LoginController {
    @FXML
    private javafx.scene.control.TextField userField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private javafx.scene.control.Label errorLabel;

    private final String user = "admin";
    private final String password = "admin";

    private  String userInput = "admin";
    private  String passwordInput = "admin";
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void submit(ActionEvent actionEvent) throws IOException {
        userInput = userField.getText();
        passwordInput = passwordField.getText();

        if(userInput.equals(user) && passwordInput.equals(password)) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Home.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setX(200);
            stage.setY(50);
            stage.show();

        }
        else {
            userField.clear();
            passwordField.clear();
            errorLabel.setText("Username o Password errati (provare admin admin)");
        }

    }



}
