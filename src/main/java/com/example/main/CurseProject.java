package com.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CurseProject extends Application {
    public void window(String resource, int wight, int height,String title){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(
                    CurseProject.class.getResource(resource));
            Scene scene = new Scene(fxmlLoader.load(), height, wight);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 360);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}