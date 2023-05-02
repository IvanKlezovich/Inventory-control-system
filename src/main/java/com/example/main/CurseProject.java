package com.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CurseProject extends Application {
    public void escLogin() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 360);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public void registration() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 360);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public void error() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("error.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360, 120);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public void provider() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("provider.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public void units() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("units.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public void order() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("order.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
    }
    public void product() throws IOException{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("product.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Curse  Project");
        stage.setScene(scene);
        stage.show();
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