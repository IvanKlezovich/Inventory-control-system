package com.example.controllers;

import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class DeleteProductController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private TextField codeField;
    @FXML
    private Button deleteButton;
    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            try {
                int code = 0;
                if (Pattern.matches("\\d+", codeField.getText().trim())){
                    code = Integer.parseInt(codeField.getText().trim());
                    db.delProduct(code);
                    System.out.println("Удаление");
                    codeField.setText("");
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Неверно введенное поле: код продукта");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        });
    }
}
