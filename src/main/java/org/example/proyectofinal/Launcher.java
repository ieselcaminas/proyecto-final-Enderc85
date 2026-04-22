package org.example.proyectofinal;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class Launcher {

    public static ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        springContext = new SpringApplicationBuilder(ProyectoFinalApplication.class)
                .web(WebApplicationType.NONE)   // 🔥 DESACTIVA TOMCAT
                .run(args);

        Application.launch(App.class, args);
    }

}
