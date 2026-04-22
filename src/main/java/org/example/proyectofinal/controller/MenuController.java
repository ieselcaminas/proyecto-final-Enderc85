package org.example.proyectofinal.controller;

import org.example.proyectofinal.App;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void onShowSeries() {
        App.setRoot("series");
    }

    @FXML
    private void onShowViewed() {
        App.setRoot("userSerie");
    }

    @FXML
    private void onLogout() {
        App.setUser(null);
        App.setRoot("login");
    }
}
