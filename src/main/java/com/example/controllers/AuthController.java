package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button authButton;
    @FXML
    private TextField authId;
    @FXML
    public void initialize(){
        authButton.setOnAction(actionEvent -> {
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_AUTHORIZATION
                    + " = '1' WHERE (" + Const.USER_ID + " = '?');";
            try {
                PreparedStatement psSt = db.getDbconnection().prepareStatement(insert);
                String authIndicator = authId.getText().trim();
                psSt.setString(1, authIndicator);

                psSt.executeUpdate();
                psSt.close();
            } catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        });
    }
}
