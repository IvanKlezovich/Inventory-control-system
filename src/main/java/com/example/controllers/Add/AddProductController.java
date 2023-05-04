package com.example.controllers.Add;

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
            boolean sate = true;
            String name = null;
            String idEnum = null;
            String des = null;
            int count = 0;
            try {
                if (Pattern.matches("\\w+", nameField.getText().trim())) {
                    name = nameField.getText().trim();
                } else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if (Pattern.matches("\\w+", enumField.getText().trim())) {
                    idEnum = enumField.getText().trim();
                } else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if(Pattern.matches("\\d+", countField.getText().trim())){
                    count = Integer.parseInt(countField.getText().trim());
                }else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели букву");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if (Pattern.matches("\\w+", desField.getText().trim())) {
                    des = desField.getText().trim();
                } else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели число");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if (sate) {
                    Product product = new Product(name, idEnum, count, des);
                    db.addProduct(product);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Все прошло хорошо");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        });
    }
}
