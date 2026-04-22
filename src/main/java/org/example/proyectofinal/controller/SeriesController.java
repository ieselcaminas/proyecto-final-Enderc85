package org.example.proyectofinal.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.proyectofinal.entity.Serie;
import org.example.proyectofinal.service.SerieService;

public class SeriesController {

    @FXML
    private TableView<Serie> seriesTable;

    @FXML
    private TableColumn<Serie, String> titleColumn;

    @FXML
    private TableColumn<Serie, String> descriptionColumn;

    @FXML
    private TableColumn<Serie, Integer> yearColumn;

    @FXML
    private TextField titleField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField yearField;

    private final SerieService serieService;
    private ObservableList<Serie> seriesList;

    public SeriesController(SerieService serieService) {
        this.serieService = serieService;
    }

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTitle()));
        descriptionColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        yearColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getYear()).asObject());

        loadSeries();
    }

    private void loadSeries() {
        seriesList = FXCollections.observableArrayList(serieService.getAllSeries());
        seriesTable.setItems(seriesList);
    }

    @FXML
    private void onAddSerie() {
        String title = titleField.getText().trim();
        String description = descriptionField.getText().trim();
        String yearText = yearField.getText().trim();

        if (title.isEmpty() || yearText.isEmpty()) {
            showAlert("Error", "El título y el año son obligatorios");
            return;
        }

        Integer year;
        try {
            year = Integer.parseInt(yearText);
        } catch (NumberFormatException e) {
            showAlert("Error", "El año debe ser un número");
            return;
        }

        Serie serie = new Serie();
        serie.setTitle(title);
        serie.setDescription(description);
        serie.setYear(year);

        serieService.save(serie);
        loadSeries();

        titleField.clear();
        descriptionField.clear();
        yearField.clear();
    }

    @FXML
    private void onDeleteSerie() {
        Serie selected = seriesTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Selecciona una serie para eliminar");
            return;
        }

        serieService.delete(selected.getId());
        loadSeries();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
