package com.example.controllers.Delete;

import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class DeleteProviderController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private TextField codeField;
    @FXML
    private Button deleteButton;
    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            int code = 0;
            if(Pattern.matches("\\d+", codeField.getText().trim())){
                code = Integer.parseInt(codeField.getText().trim());
                db.delProvider(code);
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
                alert.setContentText("вы ничего не ввели число");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");
                    }
                });
            }
        });
    }
}
