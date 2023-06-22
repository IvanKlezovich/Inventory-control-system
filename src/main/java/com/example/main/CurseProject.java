package com.example.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**This class was being creating to logging all users of company.
 * @author Ivan Klezovich
 * @version 1.0*/

public class CurseProject extends Application {

    /**This is method for compile all forms without login form.
     * @param resource path to resource.
     * @param wight wight of finish window.
     * @param height height of finish window.
     * @param title title of the window.*/

    public void window(String resource, int wight, int height,String title){
        try {Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(CurseProject.class.getResource(resource));
            Scene scene = new Scene(fxmlLoader.load(), wight, height);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This is method compile and view form of login.
     * @param stage stage
     * @throws IOException e
     */

    @Override
    public void start(Stage stage) throws IOException {
        /* FXMLLoader fxmlLoader = new FXMLLoader(
                CurseProject.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 360);
        stage.setTitle("");
        stage.setScene(scene);
        stage.show(); */
        window("changeProduct.fxml", 600, 400, " ");
        window("product.fxml", 635, 720, "product");
        //window("provider.fxml", 719, 720, "provider");
    }

    /**
     * This method was being a mount point of program.
     * @param args args
     */

    public static void main(String[] args) {
        launch();
    }
}