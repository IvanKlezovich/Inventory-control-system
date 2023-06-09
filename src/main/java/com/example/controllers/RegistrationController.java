package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**Class for registration new user
 * @author Ivan Klezovich
 * @version 1.3
 */

public class RegistrationController {
    CurseProject cp = new CurseProject();
    DatabaseHandler dh = new DatabaseHandler();
    @FXML
    private Button backButton;
    @FXML
    private TextField inputName;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Button regestrationButton;

    /**This method for registration new user to table user*/

    @FXML
    void initialize() {
        regestrationButton.setOnAction(actionEvent -> {
            String logg = inputName.getText().trim();
            String pass = inputPassword.getText().trim();
            User user = new User(logg, pass);
            dh.choiceAdd("user", user);
        });
        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();
            cp.window("login.fxml", 360, 520, "login");
        });
    }
}
