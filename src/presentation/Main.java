package presentation;

import controller.AggiungiController;
import files.GestioneFileBinari;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Discoteca;
import model.Persone;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        String pathFileP = "persone.bin";
        String pathFileM = "tipoMusica.bin";
        try {
            Persone.onOpen(pathFileP, pathFileM);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("view/Login.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Gestionale Discotyeca");
            stage.getIcons().add(new Image("presentation/img/logo2.png"));
            stage.setScene(scene);
            stage.resizableProperty().setValue(false);

            Persone.onClose(stage, pathFileP, pathFileM);

            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
