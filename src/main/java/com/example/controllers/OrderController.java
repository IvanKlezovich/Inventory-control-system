package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    void initialize(){
        initDate();
        CloseOrderButton.setOnAction(actionEvent -> {
            CloseOrderButton.getScene().getWindow().hide();
            cp.window("product.fxml", 720, 635, "product");
        });
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> cp.window("addOrder.fxml", 300, 400, "add"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteOrder.fxml", 148, 200, "delete"));
    }
    public void update(){
        orderTable.getItems().clear();
        String query = "SELECT * FROM " + Const.ORDER_TABLE + ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int idOrder = rs.getInt(Const.ID_ORDER);
                int idProvider = rs.getInt(Const.ID_PROVIDER);
                int countOfProvider = rs.getInt(Const.COUNT_ORDER);
                int prise = rs.getInt(Const.ORDER_PRISE);
                int amountOfOrder = rs.getInt(Const.AMOUNT_ORDER);
                Time deliveryTime = rs.getTime(Const.ORDER_DELIVERY_TIME);

                Order order = new Order(idOrder, idProvider, countOfProvider, prise, amountOfOrder,deliveryTime);
                orders.add(order);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        orderTable.setItems(orders);
    }
    public void initDate() {

        String query = "SELECT * FROM order;";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int idOrder = rs.getInt(Const.ID_ORDER);
                int idProvider = rs.getInt(Const.ID_PROVIDER);
                int countOfProvider = rs.getInt(Const.COUNT_ORDER);
                int prise = rs.getInt(Const.ORDER_PRISE);
                int amountOfOrder = rs.getInt(Const.AMOUNT_ORDER);
                Time deliveryTime = rs.getTime(Const.ORDER_DELIVERY_TIME);

                Order order = new Order(idOrder, idProvider, countOfProvider, prise, amountOfOrder,deliveryTime);
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

        TableColumn<Order, Integer> countOfProvider = new TableColumn<>("Count");
        countOfProvider.setCellValueFactory(new PropertyValueFactory<>("countOfProvider"));

        TableColumn<Order, Integer> prise = new TableColumn<>("prise");
        prise.setCellValueFactory(new PropertyValueFactory<>("prise"));

        TableColumn<Order, Integer> amountOfOrder = new TableColumn<>("amountOfOrder");
        amountOfOrder.setCellValueFactory(new PropertyValueFactory<>("amountOfOrder"));

        TableColumn<Order, Time> deliveryTime = new TableColumn<>("delivery");
        deliveryTime.setCellValueFactory(new PropertyValueFactory<>("deliveryTime"));

        orderTable.getColumns().addAll(idOrder, idProvider, countOfProvider, prise, amountOfOrder, deliveryTime);

        orderTable.setItems(orders);
    }
}
