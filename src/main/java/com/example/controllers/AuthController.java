package com.example.controllers;

import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AuthController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button authButton;
    @FXML
    private TextField authId;
    @FXML
    public void initialize(){
        authButton.setOnAction(actionEvent -> db.authUser(Integer.parseInt(authId.getText().trim())));
    }
}
