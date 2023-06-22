package com.example.controllers.Change;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class ChangeOrderController {

    CurseProject cp = new CurseProject();

    DatabaseHandler db = new DatabaseHandler();

    boolean state = true;

    @FXML
    private TextField IDOrderField;

    @FXML
    private Button changeButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField IDProviderField;

    @FXML
    private TextField IDProductField;

    @FXML
    private TextField priseField;

    @FXML
    private TextField amountOfOrderField;

    @FXML
    private TextField deliveryTimeField;

    /**
     *
     */

    @FXML
    void initialize(){
        changeButton.setOnAction(actionEvent -> {

            try{

                String idOrder = IDOrderField.getText().trim();
                String idProver = IDProviderField.getText().trim();
                String idProduct = IDProductField.getText().trim();
                String prise = priseField.getText().trim();
                String amountOfOrder = amountOfOrderField.getText().trim();
                String deliveryTime = deliveryTimeField.getText().trim();

                Order order = newOrder(idOrder, idProduct, idProver, prise, amountOfOrder, deliveryTime);

                if(state){

                    db.choiceChange("order", order);

                }
            }catch (Exception e){

                e.printStackTrace();

            }
        });

        exitButton.setOnAction(actionEvent -> {

            exitButton.getScene().getWindow().hide();
            cp.window("order.fxml", 687, 720, "order");

        });
    }

    public Order newOrder(String idOrder,String idProduct,String idProvider, String prise, String amountOfOrder, String deliveryTime){
        Order order = new Order();

        if(Pattern.matches("\\d+", idOrder)){order.setIdOrder(Integer.parseInt(String.valueOf(idOrder)));}else{state = false;}
        if(Pattern.matches("\\d+", idProduct)){order.setIdProduct(Integer.parseInt(String.valueOf(idProduct)));}else{state = false;}
        if(Pattern.matches("\\d+", idProvider)){order.setIdProvider(Integer.parseInt(String.valueOf(idProvider)));}else{state = false;}
        if(Pattern.matches("\\d+", prise)){order.setPrise(Integer.parseInt(String.valueOf(prise)));}else{state = false;}
        if(Pattern.matches("\\d+", amountOfOrder)){order.setAmountOfOrder(Integer.parseInt(String.valueOf(amountOfOrder)));}else{state = false;}
        if(Pattern.matches("\\d{1,2}.\\d{1,2}.\\d{1,4}", deliveryTime)){order.setDeliveryTime(deliveryTime);}else{state = false;}

        if(idProduct.equals("") || idProvider.equals("") || prise.equals("") || amountOfOrder.equals("") || deliveryTime.equals("")) {

            state = true;

            if (idProduct.equals("")) order.setIdProduct(0);
            else order.setIdProduct(Integer.parseInt(idProduct));

            if (idProvider.equals("")) order.setIdProvider(0);
            else order.setIdProvider(Integer.parseInt(idProvider));

            if (prise.equals("")) order.setPrise(0);
            else order.setPrise(Integer.parseInt(prise));

            order.setDeliveryTime(deliveryTime);

            if (amountOfOrder.equals("")) order.setAmountOfOrder(0);
            else order.setAmountOfOrder(Integer.parseInt(amountOfOrder));
        }

        if(state) return order;
        else return null;
    }
}