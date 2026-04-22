package org.example.proyectofinal;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ProyectoFinalApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProyectoFinalApplication.class)
                .web(WebApplicationType.NONE)   // 🔥 DESACTIVA TOMCAT
                .run(args);
    }
}
