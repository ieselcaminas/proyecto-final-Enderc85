package org.example.proyectofinal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.example.proyectofinal.App;
import org.example.proyectofinal.entity.User;
import org.example.proyectofinal.service.UserService;

public class LoginController {

    @FXML
    private TextField usernameField;

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private void onLoginClick() {
        String username = usernameField.getText().trim();

        if (username.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "El nombre de usuario no puede estar vacío").show();
            return;
        }

        User user = userService.login(username);

        if (user == null) {
            user = userService.register(username);
            if (user == null) {
                new Alert(Alert.AlertType.ERROR, "No se pudo crear el usuario").show();
                return;
            }
            new Alert(Alert.AlertType.INFORMATION, "Usuario creado correctamente").show();
        }

        App.setUser(user);
        App.setRoot("menu");
    }
}
