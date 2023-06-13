package com.example.controllers.Change;

import com.example.connection.DatabaseHandler;
import com.example.tables.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class ChangeProductController {

    DatabaseHandler db = new DatabaseHandler();

    boolean state = true;

    @FXML
    private TextField IDField;

    @FXML
    private Button changeButton;

    @FXML
    private TextField countField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField unitField;

    @FXML
    void initialize(){
        changeButton.setOnAction(actionEvent -> {

            try{
                String idProduct = IDField.getText().trim();
                String name = nameField.getText().trim();
                String count = countField.getText().trim();
                String dis = descriptionField.getText().trim();
                String unId = unitField.getText().trim();

                Product product = newProd(idProduct, name, unId, dis, count);

                if(state) {
                    db.choiceChange("product", product);
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
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public Product newProd(String idProduct, String name, String idEnum, String des, String count){
        Product product = new Product();

        if(Pattern.matches("\\d+", idProduct)){
            product.setIdProduct(Integer.parseInt(String.valueOf(idProduct)));
        } else {
            state = false;
        }
        if (Pattern.matches("\\w+", name)) {
            product.setNameProduct(name);
        } else {
            state = false;
        }
        if (Pattern.matches("\\d+", idEnum)){
            product.setIdUnits(Integer.parseInt(String.valueOf(idEnum)));
        } else {
            state = false;
        }
        if(Pattern.matches("\\d+", count)){
            product.setCountWare(Integer.parseInt(count));
        }else {
            state = false;
        }
        if (Pattern.matches("\\w+", des)){
            product.setDescription(des);
        } else {
            state = false;
        }
        if (count.equals("") || des.equals("") || idEnum.equals("") || name.equals("")) {
            state = true;
            product.setNameProduct(name);
            if (idEnum.equals("")) {
                product.setIdUnits(0);
            } else {
                product.setIdUnits(Integer.parseInt(idEnum));
            }
            if (count.equals("")) {
                product.setCountWare(0);
            } else {
                product.setCountWare(Integer.parseInt(count));
            }
            product.setDescription(des);
        }
        if(state) return product;
        else return null;
    }
}
