package com.example.controllers.Change;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Units;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class ChangeUnitsController {

    CurseProject cp = new CurseProject();

    DatabaseHandler db = new DatabaseHandler();

    boolean state = true;

    @FXML
    private TextField idUnitsField;

    @FXML
    private TextField unitsNameField;

    @FXML
    private Button changeButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize(){
        changeButton.setOnAction(actionEvent -> {

            try{

                String idUnits = idUnitsField.getText().trim();
                String unitsName = unitsNameField.getText().trim();

                Units units = newUnits(idUnits, unitsName);

                if(state){

                    db.choiceChange("units", units);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Все прошло хорошо");
                    alert.showAndWait().ifPresent(rs -> {});

                }
                else{

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
                    alert.showAndWait().ifPresent(rs -> {});

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

        });

        exitButton.setOnAction(actionEvent -> {

            exitButton.getScene().getWindow().hide();
            cp.window("units.fxml", 335, 335, "units");

        });
    }

    public Units newUnits(String idUnits, String unitsName){
        Units units = new Units();

        if(Pattern.matches("\\d+", idUnits)) units.setIdUnit(Integer.parseInt(idUnits)); else state = false;

        if (Pattern.matches("\\w+", unitsName) || unitsName.equals("")){ units.setNameUnit(unitsName); }else{ state = false; }

        if(state) return units;
        else return null;
    }
}
