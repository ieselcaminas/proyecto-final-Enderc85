package org.example.proyectofinal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.example.proyectofinal.App;
import org.example.proyectofinal.entity.User;
import org.example.proyectofinal.entity.UserSerie;
import org.example.proyectofinal.service.UserSerieService;

public class UserSerieController {

    @FXML
    private ListView<UserSerie> viewedSeriesList;

    @FXML
    private Button backButton;

    private final UserSerieService userSerieService;

    public UserSerieController(UserSerieService userSerieService) {
        this.userSerieService = userSerieService;
    }

    @FXML
    private void initialize() {
        User loggedUser = App.getUser();

        if (loggedUser != null) {
            // Cargar todas las series vistas por el usuario desde SQLite
            viewedSeriesList.getItems().setAll(userSerieService.getViewedByUser(loggedUser));
        }
    }

    @FXML
    private void onBack() {
        App.setRoot("menu");
    }
}
