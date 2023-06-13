package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Units;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class AddUnitsController {

    boolean state = true;
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button AddButton;
    @FXML
    private TextField nameField;
    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            String name;
            try {
                name = nameField.getText().trim();
                Units units = newUnit(name);

                if (state){
                    db.choiceAdd("units", units);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Все прошло успешно");
                    alert.showAndWait().ifPresent(rs -> {});
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели число");
                    alert.showAndWait().ifPresent(rs -> {});
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public Units newUnit(String name){

        Units unit = new Units();

        if (Pattern.matches("\\w+", nameField.getText().trim())){
            unit.setNameUnit(name);
        }else{
            state = false;
        }

        if(state) return unit;
        else return null;
    }
}
