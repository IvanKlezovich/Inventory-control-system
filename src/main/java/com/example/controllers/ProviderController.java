package com.example.controllers;

import com.example.main.CurseProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ProviderController {

    CurseProject cp = new CurseProject();

    @FXML
    private Button CloseProviderButton;

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
        CloseProviderButton.setOnAction(actionEvent -> {
            CloseProviderButton.getScene().getWindow().hide();
            try{
                cp.product();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }
}
