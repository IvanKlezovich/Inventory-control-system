package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.tables.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class AddProductController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button AddButton;
    @FXML
    private TextField countField;
    @FXML
    private TextField desField;
    @FXML
    private TextField enumField;
    @FXML
    private TextField nameField;
    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            boolean state = true;
            try {
                String name = null;
                if (Pattern.matches("\\w+", nameField.getText().trim())){
                    name = nameField.getText().trim();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Неверно введенное поле: название продукта");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                    state = false;
                }
                String idEnum = null;
                if (Pattern.matches("\\w+", enumField.getText().trim())){
                    idEnum = enumField.getText().trim();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Неверно введенное поле: код единицы измерения");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                    state = false;
                }
                int count = 0;
                if (Pattern.matches("\\d+", countField.getText().trim())) {
                    count = Integer.parseInt(countField.getText().trim());
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Неверно введенное поле: количество продукта");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                    state = false;
                }
                String des = null;
                if (Pattern.matches("\\w+", desField.getText().trim())){
                    des = desField.getText().trim();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Неверно введенное поле: примечание");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                    state = false;
                }
                if(state){
                    Product product = new Product(name, idEnum, count, des);
                    db.addProduct(product);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Все прошло по плану");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
