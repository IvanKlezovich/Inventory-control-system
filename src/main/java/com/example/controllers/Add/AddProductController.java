package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

/**Class for managing the add product form
 * @author Ivan Klezovich
 * @version 1.2 */

public class AddProductController {
    boolean sate = true;
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button AddButton;
    @FXML
    private TextField countField;
    @FXML
    private TextField desField;
    @FXML
    private TextField enumField;
    @FXML
    private TextField nameField;

    /**Method for migrate data from form to database.
     * nameField - name product
     * enumField - number enum
     * desField - description
     * countField - count of product
     */

    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            String name;
            String idEnum;
            String des;
            String count;
            try {
                name = nameField.getText().trim();
                idEnum = enumField.getText().trim();
                count = countField.getText().trim();
                des = desField.getText().trim();
                Product product = newUser(name, idEnum, des, count);
                if (sate) {
                    db.choiceAdd("product", product);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Все прошло хорошо");
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("вы ничего не ввели или ввели цифру");
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

    /**Method for protection against incorrect data entry
     * @param name banana
     * @param idEnum 2
     * @param des no
     * @param count 89
     * @return product("banana", 2, 89, no)
     * or null if data has been incorrect.
     */

    public Product newUser(String name, String idEnum, String des, String count){
        Product product = new Product();

        if (Pattern.matches("\\w+", name)) {
            product.setNameProduct(name);
        } else {
            sate = false;
        }
        if (Pattern.matches("\\d+", idEnum)) {
            product.setIdUnits(Integer.parseInt(String.valueOf(idEnum)));
        } else {
            sate = false;
        }
        if(Pattern.matches("\\d+", count)){
            product.setCountWare(Integer.parseInt(count));
        }else {
            sate = false;
        }
        if (Pattern.matches("\\w+", des)) {
             product.setDescription(des);
        } else {
            sate = false;
        }
        if(sate) {
            return product;
        }else return null;
    }
}
