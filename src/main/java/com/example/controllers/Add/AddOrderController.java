package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Order;
import com.example.tables.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddOrderController {
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button AddButton;
    @FXML
    private TextField countField;
    @FXML
    private TextField delField;
    @FXML
    private TextField idProdField;
    @FXML
    private TextField idProvField;
    @FXML
    private TextField priseField;
    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            int idProvider = Integer.parseInt(idProvField.getText().trim());;
            int prise = Integer.parseInt(priseField.getText().trim());;
            int amountOfOrder = Integer.parseInt(countField.getText().trim());;
            int idProduct = Integer.parseInt(idProdField.getText().trim());
            String del = delField.getText().trim();
            Order order = new Order(idProvider, idProduct, prise, amountOfOrder, del);
            db.addOrder(order);
        });
    }
}
