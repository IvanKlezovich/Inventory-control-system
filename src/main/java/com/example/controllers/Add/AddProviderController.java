package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Provider;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class AddProviderController {
    boolean state = true;
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
            String FIO;
            String numberPhone;
            String add;
            String numberOfAcc;
            try {
                FIO = FIOField.getText().trim();
                numberPhone = numPhoField.getText().trim();
                add = addField.getText().trim();
                numberOfAcc = numAccField.getText().trim();
                Provider provider = newProv(FIO, numberPhone, add, numberOfAcc);

                if (state) {
                    db.choiceAdd("provider", provider);
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
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        });
    }

    public Provider newProv(String Fio, String numberPhone, String add, String numberOfAcc){

        Provider provider = new Provider();

        if(Pattern.matches("\\w+\\s\\w+", Fio)){
            provider.setFIO(Fio);
        }
        else{
            state = false;
        }
        if (Pattern.matches("\\+\\d{1,3}\\d{2}\\d{1,7}", numberPhone)){
            provider.setNumberPhone(numberPhone);
        }
        else{
            state = false;
        }
        if (Pattern.matches("\\w+\\s\\d{1,3}", add)){
            provider.setAddress(add);
        }
        else{
            state = false;
        }
        if (Pattern.matches("\\d+", numAccField.getText().trim())){
            provider.setNumberAccount(Integer.parseInt(numberOfAcc));
        }
        else{
            state = false;
        }
        if(state) return provider;
        else return null;
    }
}
