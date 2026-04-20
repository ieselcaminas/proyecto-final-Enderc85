module org.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires jakarta.persistence;
    requires com.fasterxml.jackson.annotation;
    requires spring.data.commons;
    requires spring.context;
    requires jakarta.transaction;
    requires spring.web;
    requires org.apache.tomcat.embed.core;
    requires spring.beans;

    opens org.example.proyectofinal to javafx.fxml;
    exports org.example.proyectofinal;
}