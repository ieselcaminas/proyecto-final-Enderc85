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

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.setTitle("SeenIt");
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        loader.setControllerFactory(param -> {
            if (param == LoginController.class)
                return new LoginController(Launcher.springContext.getBean(UserService.class));

            if (param == MenuController.class)
                return new MenuController();

            if (param == SeriesController.class)
                return new SeriesController(Launcher.springContext.getBean(SerieService.class));

            if (param == UserSerieController.class)
                return new UserSerieController(Launcher.springContext.getBean(UserSerieService.class));

            return null;
        });

        return loader.load();
    }

    public static void setUser(User user) {
        loggedUser = user;
    }

    public static User getUser() {
        return loggedUser;
    }
}
