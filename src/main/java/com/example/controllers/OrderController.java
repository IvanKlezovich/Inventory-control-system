package com.example.controllers;


import com.example.main.CurseProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;

public class OrderController {

    CurseProject cp = new CurseProject();
    @FXML
    private Button CloseOrderButton;

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
        CloseOrderButton.setOnAction(actionEvent -> {
            CloseOrderButton.getScene().getWindow().hide();
            try{
                cp.product();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

}
