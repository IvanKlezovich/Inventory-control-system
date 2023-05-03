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
    private TableView<Product> productTable;
    @FXML
    private Button OpenOrderButton;
    @FXML
    private Button OpenProviderButton;
    @FXML
    private Button OpenUnitsButton;
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
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> cp.window("addProduct.fxml", 300, 400, "addProduct"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteProduct.fxml", 148, 200, "delete"));
    }
    public void update(){
        productTable.getItems().clear();
        String update = "SELECT * FROM products";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(update);
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
        }

        productTable.setItems(products);
    }
    @SuppressWarnings("unchecked")
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
        }

        TableColumn<Product, Integer> idOfProduct = new TableColumn<>("Id_product");
        idOfProduct.setCellValueFactory(new PropertyValueFactory<>("idOfProduct"));

        TableColumn<Product, String> nameOfProduct = new TableColumn<>("name_Product");
        nameOfProduct.setCellValueFactory(new PropertyValueFactory<>("nameOfProduct"));

        TableColumn<Product, String> idOfEnum = new TableColumn<>("Id_Enum");
        idOfEnum.setCellValueFactory(new PropertyValueFactory<>("idOfEnum"));

        TableColumn<Product, Integer> countOfWare = new TableColumn<>("count_ware");
        countOfWare.setCellValueFactory(new PropertyValueFactory<>("countOfWare"));

        TableColumn<Product, String> description = new TableColumn<>("description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        productTable.getColumns().addAll(idOfProduct, nameOfProduct,idOfEnum, countOfWare, description);

        productTable.setItems(products);
    }
}