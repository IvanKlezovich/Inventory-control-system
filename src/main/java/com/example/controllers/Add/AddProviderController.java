package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Provider;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class AddProviderController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button AddButton;
    @FXML
    private TextField FIOField;
    @FXML
    private TextField addField;
    @FXML
    private TextField numAccField;
    @FXML
    private TextField numPhoField;
    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            boolean sate = true;
            String FIO = null;
            String numberPhone = null;
            String add = null;
            int numberOfAcc = 0;
            try {
                if (Pattern.matches("\\w+\\s\\w+", FIOField.getText().trim())) {
                    FIO = FIOField.getText().trim();
                }
                else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if (Pattern.matches("\\+\\d{1,3}\\d{2}\\d{1,7}", numPhoField.getText().trim())) {
                    numberPhone = numPhoField.getText().trim();
                }
                else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if(Pattern.matches("\\w+\\s\\d{1,3}", addField.getText().trim())){
                    add = addField.getText().trim();
                }
                else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели букву");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if (Pattern.matches("\\d+", numAccField.getText().trim())) {
                    numberOfAcc = Integer.parseInt(numAccField.getText().trim());
                }
                else {
                    sate = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели число");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                if (sate) {
                    Provider provider = new Provider(FIO, numberPhone, add, numberOfAcc);
                    db.addProvider(provider);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Все прошло хорошо");
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
