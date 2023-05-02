package com.example.controllers;


import com.example.main.CurseProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;

public class UnitsController {

    CurseProject cp = new CurseProject();
    @FXML
    private Button CloseUnitsButton;

    @FXML
    private TableView<?> Table;

    @FXML
    private Button deleteButton;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    void initialize(){
        CloseUnitsButton.setOnAction(actionEvent -> {
            CloseUnitsButton.getScene().getWindow().hide();
            cp.window("product.fxml", 720, 635, "product");
        });
    }
}
