package com.example.controllers;

import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**This class for authentication form
 * @author Ivan Klezovich
 * @version 1.3*/
public class AuthController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button authButton;
    @FXML
    private TextField authId;
    /**This method for migrate form data to update data in database*/
    @FXML
    public void initialize(){
        authButton.setOnAction(actionEvent -> db.authUser(Integer.parseInt(authId.getText().trim())));
    }
}
