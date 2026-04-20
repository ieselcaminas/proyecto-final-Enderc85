package org.example.proyectofinal;

import controller.LoginController;
import controller.MenuController;
import controller.SeriesController;
import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.SerieRepository;
import repository.UserRepository;
import repository.UserSerieRepository;
import service.SerieService;
import service.UserSerieService;
import service.UserService;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static User loggedUser;

    private static UserService userService = new UserService(new UserRepository());
    private static SerieService serieService = new SerieService(new SerieRepository());
    private static UserSerieService userSerieService = new UserSerieService(
            new UserSerieRepository(),
            new UserRepository(),
            new SerieRepository()
    );

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setUser(User user) {
        loggedUser = user;
    }

    public static User getUser() {
        return loggedUser;
    }

    private static Parent loadFXML(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

            loader.setControllerFactory(param -> {
                if (param == LoginController.class) return new LoginController(userService);
                if (param == MenuController.class) return new MenuController();
                if (param == SeriesController.class) return new SeriesController(serieService, userSerieService);
                return null;
            });

            return loader.load();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
