package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Units;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class AddUnitsController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button AddButton;
    @FXML
    private TextField nameField;
    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            if(Pattern.matches("\\w+", nameField.getText().trim())){
                String name = nameField.getText().trim();
                Units units = new Units(name);
                db.choiceAdd("units", units);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Все прошло успешно");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("вы ничего не ввели или ввели число");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }
        });
    }
}
