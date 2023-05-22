package com.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * This class was being creating to authorisation users.
 * @author Ivan Klezovich
 * @version 1.2
 */
public class AuthorizationNewUser extends Application{
    /**
     * This is method compile and view form of authorization.
     * This file must be to another computer and connect to some base.
     * @param stage stage
     * @throws IOException e
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                AuthorizationNewUser.class.getResource("authForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 148);
        stage.setTitle("Curse");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This method was being a mount point of authorisation process.
     * @param args args
     */
    public static void main(String[] args){launch();}
}
