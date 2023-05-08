package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class OrderController {
    private final ObservableList<Order> orders = FXCollections.observableArrayList();
    CurseProject cp = new CurseProject();
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button CloseOrderButton;
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private Button deleteButton;
    @FXML
    private Button insertButton;
    @FXML
    private Button updateButton;
    @FXML
    private TextField searchField;
    @FXML
    void initialize(){
        initDate();
        CloseOrderButton.setOnAction(actionEvent -> {
            CloseOrderButton.getScene().getWindow().hide();
            cp.window("product.fxml", 720, 635, "product");
        });
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Order> searchOrder = new FilteredList<>(orders);
            System.out.println(searchField.getText().trim());
            searchOrder.setPredicate(order -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCase = newValue.toLowerCase();
                if(String.valueOf(order.getIdOrder()).contains(lowerCase)) return true;
                else if (String.valueOf(order.getAmountOfOrder()).contains(lowerCase)) return true;
                else if(String.valueOf(order.getPrise()).contains(lowerCase)) return true;
                else if(String.valueOf(order.getIdProvider()).contains(lowerCase)) return true;
                else if(String.valueOf(order.getIdProduct()).contains(lowerCase)) return true;
                else return order.getDeliveryTime().toLowerCase().contains(lowerCase);
                });
            orderTable.setItems(searchOrder);
        });
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> cp.window("addOrder.fxml", 300, 400, "add"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteOrder.fxml", 148, 200, "delete"));
    }
    public void update(){
        orders.clear();
        String query = "SELECT * FROM " + Const.ORDER_TABLE + ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int idOrder = rs.getInt(Const.ORDER_ID);
                int idProvider = rs.getInt(Const.PROVIDER_ID);
                int idProduct = rs.getInt(Const.PRODUCT_ID);
                int prise = rs.getInt(Const.ORDER_PRISE);
                int amountOfOrder = rs.getInt(Const.ORDER_AMOUNT);
                String deliveryTime = rs.getString(Const.ORDER_DELIVERY_TIME);

                Order order = new Order(idOrder, idProvider, idProduct, prise, amountOfOrder,deliveryTime);
                orders.add(order);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        orderTable.setItems(orders);
    }
    public void initDate() {

        String query = "SELECT * FROM "+ Const.ORDER_TABLE +";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int idOrder = rs.getInt(Const.ORDER_ID);
                int idProvider = rs.getInt(Const.PROVIDER_ID);
                int idProduct = rs.getInt(Const.PRODUCT_ID);
                int prise = rs.getInt(Const.ORDER_PRISE);
                int amountOfOrder = rs.getInt(Const.ORDER_AMOUNT);
                String deliveryTime = rs.getString(Const.ORDER_DELIVERY_TIME);

                Order order = new Order(idOrder, idProvider, idProduct, prise, amountOfOrder,deliveryTime);
                orders.add(order);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        TableColumn<Order, Integer> idOrder = new TableColumn<>("Id_order");
        idOrder.setCellValueFactory(new PropertyValueFactory<>("idOrder"));

        TableColumn<Order, Integer> idProvider = new TableColumn<>("Id_provider");
        idProvider.setCellValueFactory(new PropertyValueFactory<>("idProvider"));

        TableColumn<Order, Integer> idProduct = new TableColumn<>("id_product");
        idProduct.setCellValueFactory(new PropertyValueFactory<>("idProduct"));

        TableColumn<Order, Integer> prise = new TableColumn<>("prise");
        prise.setCellValueFactory(new PropertyValueFactory<>("prise"));

        TableColumn<Order, Integer> amountOfOrder = new TableColumn<>("amountOfOrder");
        amountOfOrder.setCellValueFactory(new PropertyValueFactory<>("amountOfOrder"));

        TableColumn<Order, Time> deliveryTime = new TableColumn<>("delivery");
        deliveryTime.setCellValueFactory(new PropertyValueFactory<>("deliveryTime"));

        orderTable.getColumns().addAll(idOrder, idProvider, idProduct, prise, amountOfOrder, deliveryTime);

        orderTable.setItems(orders);
    }
}
