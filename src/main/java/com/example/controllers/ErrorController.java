package com.example.controllers;

import com.example.main.CurseProject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**This class for control form error
 * @author Ivan Klezovich
 * @version 1.3*/

public class ErrorController {
    CurseProject curseProject = new CurseProject();
    @FXML
    private Button errorButton;

    /**On authentication error, shows the error form and displays the registration form*/

    @FXML
    void initialize() {
        errorButton.setOnAction(actionEvent -> {
            errorButton.getScene().getWindow().hide();
            curseProject.window("registration.fxml", 360, 520, "registration");
        });

    }
}
