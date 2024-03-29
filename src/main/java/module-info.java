module com.example.curse {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.main to javafx.fxml;
    exports com.example.main;
    exports com.example.controllers;
    opens com.example.controllers to javafx.fxml;
    exports com.example.connection;
    opens com.example.connection to javafx.fxml;
    exports com.example.tables;
    opens com.example.tables to javafx.fxml;
}