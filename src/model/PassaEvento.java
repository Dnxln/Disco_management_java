package model;

import controller.HomeController;
import javafx.event.ActionEvent;

public class PassaEvento extends HomeController {
    private static ActionEvent event;

    public static void setEvent(ActionEvent event) {
        PassaEvento.event = event;
    }

    public static ActionEvent getEvent() {
        return event;
    }
}
