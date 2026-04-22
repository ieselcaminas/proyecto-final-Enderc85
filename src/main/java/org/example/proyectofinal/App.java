package org.example.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.proyectofinal.controller.*;
import org.example.proyectofinal.entity.User;
import org.example.proyectofinal.service.*;

public class App extends Application {

    private static Scene scene;
    private static User loggedUser;

    private UserService userService;
    private SerieService serieService;
    private UserSerieService userSerieService;

    @Override
    public void init() {
        userService = Launcher.springContext.getBean(UserService.class);
        serieService = Launcher.springContext.getBean(SerieService.class);
        userSerieService = Launcher.springContext.getBean(UserSerieService.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("login.fxml"));

        loader.setControllerFactory(param -> {
            if (param == LoginController.class) return new LoginController(userService);
            if (param == MenuController.class) return new MenuController();
            if (param == SeriesController.class) return new SeriesController(Launcher.springContext.getBean(SerieService.class));
            if (param == UserSerieController.class) return new UserSerieController(userSerieService);
            return null;
        });

        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            Parent root = loader.load();
            scene.setRoot(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUser(User user) {
        loggedUser = user;
    }

    public static User getUser() {
        return loggedUser;
    }
}
