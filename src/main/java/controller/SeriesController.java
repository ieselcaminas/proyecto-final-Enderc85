package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import entity.Serie;
import service.SerieService;
import service.UserSerieService;

public class SeriesController {

    private final SerieService serieService;
    private final UserSerieService userSerieService;

    @FXML
    private ListView<Serie> seriesList;

    public SeriesController(SerieService serieService, UserSerieService userSerieService) {
        this.serieService = serieService;
        this.userSerieService = userSerieService;
    }

    @FXML
    private void initialize() {
        seriesList.getItems().setAll(serieService.getAllSeries());
    }

    @FXML
    private void onBack() {
        org.example.proyectofinal.App.setRoot("menu");
    }
}
