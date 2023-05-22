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
    boolean sate = true;
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
            String name;
            String idEnum;
            String des;
            String count;
            try {
                name = nameField.getText().trim();
                idEnum = enumField.getText().trim();
                count = countField.getText().trim();
                des = desField.getText().trim();
                Product product = newUser(name, idEnum, des, count);
                if (sate) {
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
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
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
    public Product newUser(String name, String idEnum, String des, String count){
        Product product = new Product();

        if (Pattern.matches("\\w+", name)) {
            product.setNameProduct(name);
        } else {
            sate = false;
        }
        if (Pattern.matches("\\d+", idEnum)) {
            product.setIdUnits(Integer.parseInt(String.valueOf(idEnum)));
        } else {
            sate = false;
        }
        if(Pattern.matches("\\d+", count)){
            product.setCountWare(Integer.parseInt(count));
        }else {
            sate = false;
        }
        if (Pattern.matches("\\w+", des)) {
             product.setDescription(des);
        } else {
            sate = false;
        }
        if(sate) {
            return product;
        }else return null;
    }
}
