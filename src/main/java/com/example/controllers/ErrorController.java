package com.example.controllers;

import java.io.IOException;
import com.example.main.CurseProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ErrorController {
    CurseProject cp = new CurseProject();

    @FXML
    private Button errorButton;

    @FXML
    void initialize() {
        errorButton.setOnAction(actionEvent -> {
            errorButton.getScene().getWindow().hide();
            try {
                cp.escLogin();
            }catch (IOException e){
                e.printStackTrace();
            }
        });

    }
}
