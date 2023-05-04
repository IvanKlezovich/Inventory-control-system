package com.example.controllers.Delete;

import com.example.connection.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteUnitsController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private TextField codeField;
    @FXML
    private Button deleteButton;
    @FXML
    void initialize(){
        deleteButton.setOnAction(actionEvent -> {
            int code = Integer.parseInt(codeField.getText().trim());
            db.delUnits(code);
            System.out.println("Удаление");
            codeField.setText("");
        });
    }
}
