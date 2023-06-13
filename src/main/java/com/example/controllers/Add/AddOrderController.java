package com.example.controllers.Add;

import com.example.connection.DatabaseHandler;
import com.example.tables.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

/**Этот класс для управления формой добавления заказа
 * @author Ivan Klezovich
 * @version 1.2 */
public class AddOrderController {
    boolean state = true;
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
    /**Этот метод создан для того что-бы переводить текст из полей в базу данных
     * addButton - кнопка добавления
     * idProvField - номер провайдера
     * priseField - цена
     * countField - количество продукта
     * idProdField - номер продукта
     * delField - время доставки*/
    @FXML
    public void initialize(){
        AddButton.setOnAction(actionEvent -> {
            try {
                String idProvider = idProvField.getText().trim();
                String prise = priseField.getText().trim();
                String amountOfOrder = countField.getText().trim();
                String idProduct = idProdField.getText().trim();
                String del = delField.getText().trim();
                Order order = newOrder(idProvider, idProduct, prise, amountOfOrder, del);
                if(state) {
                    db.choiceAdd("order", order);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("все прошло успешно");
                    alert.showAndWait().ifPresent(rs ->{});
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.showAndWait().ifPresent(rs-> {});
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
    }
    public Order newOrder(String idProvider, String prise, String amountOfOrder, String idProduct, String del){

        Order order = new Order();

        if(Pattern.matches("\\d+", idProvider)){
            order.setIdProvider(Integer.parseInt(idProvider));
        }
        else{
            state = false;
        }

        if(Pattern.matches("\\d+", idProduct)){
            order.setIdProduct(Integer.parseInt(idProduct));
        }
        else{
            state = false;
        }

        if(Pattern.matches("\\d+", prise)){
            order.setPrise(Integer.parseInt(prise));
        }
        else{
            state = false;
        }

        if(Pattern.matches("\\d+", amountOfOrder))
            order.setAmountOfOrder(Integer.parseInt(amountOfOrder));
        else{
            state = false;
        }
        order.setDeliveryTime(del); // regex "2.2.4_at_2:2";

        if(state){
            return order;
        }
        else {
            return null;
        }
    }
}