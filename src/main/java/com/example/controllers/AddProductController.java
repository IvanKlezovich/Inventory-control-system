package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.tables.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
            String name = nameField.getText().trim();
            String idEnum = enumField.getText().trim();
            int count = Integer.parseInt(countField.getText().trim());
            String des = desField.getText().trim();
            Product product = new Product(name, idEnum, count, des);
            db.addProduct(product);
        });
    }
}
