package com.example.controllers;

import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteProductController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private TextField codeField;
    @FXML
    private Button deleteButton;
    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            int code = Integer.parseInt(codeField.getText().trim());
            db.delProduct(code);
            System.out.println("Удаление");
            codeField.setText("");
        });
    }
}
