package controller;

import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import service.UserService;
import org.example.proyectofinal.App;

public class LoginController {

    @FXML
    private TextField usernameField;

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private void onLoginClick() {
        String username = usernameField.getText();

        User user = userService.login(username);

        if (user != null) {
            App.setUser(user); // guardar usuario logueado
            App.setRoot("menu"); // cambiar pantalla
        } else {
            new Alert(Alert.AlertType.ERROR, "Usuario no encontrado").show();
        }
    }
}
