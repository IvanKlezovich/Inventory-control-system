package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductController {
    private final ObservableList<Product> products = FXCollections.observableArrayList();
    private final CurseProject cp = new CurseProject();
    private final DatabaseHandler db = new DatabaseHandler();


    @FXML
    private Button OpenOrderButton;

    @FXML
    private Button OpenProviderButton;

    @FXML
    private Button OpenUnitsButton;

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> idOfProduct;
    @FXML
    private TableColumn<Product, String> nameOfProduct;
    @FXML
    private TableColumn<Product, String> idOfEnum;
    @FXML
    private TableColumn<Product, Integer> countOfWare;
    @FXML
    private TableColumn<Product, String> description;

    @FXML
    private Button deleteButton;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    void initialize(){
        initDate();
        OpenOrderButton.setOnAction(actionEvent -> {
           OpenOrderButton.getScene().getWindow().hide();
           cp.window("order.fxml", 720, 1280, "order");
        });
        OpenProviderButton.setOnAction(actionEvent -> {
            OpenProviderButton.getScene().getWindow().hide();
            cp.window("provider.fxml", 720, 1280, "provider");
        });
        OpenUnitsButton.setOnAction(actionEvent -> {
            OpenUnitsButton.getScene().getWindow().hide();
            cp.window("units.fxml", 720, 1280, "units");
        });
        updateButton.setOnAction(actionEvent -> {
            System.out.println("нажали на обновление");
            //cp.window();
        });
        insertButton.setOnAction(actionEvent -> {
            System.out.println("нажали на добавление");

        });
        deleteButton.setOnAction(actionEvent -> {
            System.out.println("нажали на удаление");

        });
    }

    private void initDate() {

        String query = "SELECT * FROM products";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("idOfProduct");
                String name = rs.getString("nameOfProduct");
                String idEnum = rs.getString("idOfEnum");
                int count = rs.getInt("countOfWare");
                String des = rs.getString("description");

                Product product = new Product(id, name, idEnum, count, des);
                products.add(product);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        idOfProduct.setCellValueFactory(new PropertyValueFactory<>("id_product"));
        /*nameOfProduct.setCellValueFactory(new PropertyValueFactory<>("name_product"));
        idOfEnum.setCellValueFactory(new PropertyValueFactory<>("id_enum"));
        countOfWare.setCellValueFactory(new PropertyValueFactory<>("count_ware"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        productTable.setItems(products);*/
        }
    }
}
