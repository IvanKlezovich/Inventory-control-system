package com.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationNewUser extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                AuthorizationNewUser.class.getResource("authForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 148);
        stage.setTitle("Curse");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){launch();}
}
