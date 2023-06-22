package com.example.controllers.Change;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Provider;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class ChangeProviderController {

    CurseProject cp = new CurseProject();

    DatabaseHandler db = new DatabaseHandler();

    boolean state = false;

    @FXML
    private TextField IDProviderField;

    @FXML
    private TextField NumberField;

    @FXML
    private TextField FioField;

    @FXML
    private TextField AddressField;

    @FXML
    private TextField AccountField;

    @FXML
    private Button changeButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize(){
        changeButton.setOnAction(actionEvent -> {
            try{
                String idProvider = IDProviderField.getText().trim();
                String numberPhone = NumberField.getText().trim();
                String fio = FioField.getText().trim();
                String address = AddressField.getText().trim();
                String account = AccountField.getText().trim();

                Provider provider = newProv(idProvider, numberPhone, fio, address, account);

                if(state) {
                    db.choiceChange("provider", provider);
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
            }catch (Exception e) {
                e.printStackTrace();
            }
        });
        exitButton.setOnAction(actionEvent -> {

            exitButton.getScene().getWindow().hide();
            cp.window("provider.fxml", 720, 719, "provider");

        });
    }

    /**
     *
     * @param idProvider
     * @param numberPhone
     * @param fio
     * @param address
     * @param account
     * @return
     */

    public Provider newProv(String idProvider, String numberPhone, String fio, String address, String account){
        Provider provider = new Provider();

        if(Pattern.matches("\\d+", idProvider)){
            provider.setIdProvider(Integer.parseInt(String.valueOf(idProvider)));
        } else {
            state = false;
        }
        if (Pattern.matches("\\+\\d{1,3}\\d{2}\\d{1,7}", numberPhone)) {
            provider.setNumberPhone(numberPhone);
        } else {
            state = false;
        }
        if (Pattern.matches("\\d+", fio)){
            provider.setFIO(fio);
        } else {
            state = false;
        }
        if(Pattern.matches("\\d+", account)){
            provider.setNumberAccount(Integer.parseInt(account));
        }else {
            state = false;
        }
        if (Pattern.matches("\\w+", address)){
            provider.setAddress(address);
        } else {
            state = false;
        }
        if (account.equals("") || address.equals("") || fio.equals("") || numberPhone.equals("")) {
            state = true;
            if(account.equals("")){
                provider.setNumberAccount(0);
            }
            if(fio.equals("")){
                provider.setFIO("");
            }
            if(address.equals("")){
                provider.setAddress("");
            }
            if(numberPhone.equals("")){
                provider.setNumberAccount(0);
            }
        }
        if(state) return provider;
        else return null;
    }
}
