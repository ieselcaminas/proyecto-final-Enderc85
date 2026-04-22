package org.example.proyectofinal.controller;

import org.example.proyectofinal.entity.Serie;
import org.example.proyectofinal.entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.example.proyectofinal.App;
import org.example.proyectofinal.service.SerieService;
import org.example.proyectofinal.service.UserSerieService;

public class SerieController {

    private final SerieService serieService;
    private final UserSerieService userSerieService;

    @FXML
    private ListView<Serie> seriesList;

    @FXML
    private Button markViewedButton;

    public SerieController(SerieService serieService, UserSerieService userSerieService) {
        this.serieService = serieService;
        this.userSerieService = userSerieService;
    }

    @FXML
    private void initialize() {
        // Cargar todas las series desde la base de datos
        seriesList.getItems().setAll(serieService.getAllSeries());

        // Desactivar botón si no hay selección
        markViewedButton.setDisable(true);

        seriesList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            markViewedButton.setDisable(newVal == null);
        });
    }

    @FXML
    private void onMarkViewed() {
        Serie selected = seriesList.getSelectionModel().getSelectedItem();
        User loggedUser = App.getUser();

        if (selected != null && loggedUser != null) {
            userSerieService.markAsViewed(loggedUser, selected);
        }
    }

    @FXML
    private void onBack() {
        App.setRoot("menu");
    }
}
