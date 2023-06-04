package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Product;
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
    private TextField searchField;
    @FXML
    void initialize(){
        initDate();
        OpenOrderButton.setOnAction(actionEvent -> {
           OpenOrderButton.getScene().getWindow().hide();
            cp.window("order.fxml", 720, 687, "order");
        });
        OpenProviderButton.setOnAction(actionEvent -> {
            OpenProviderButton.getScene().getWindow().hide();
            cp.window("provider.fxml", 719, 720, "provider");
        });
        OpenUnitsButton.setOnAction(actionEvent -> {
            OpenUnitsButton.getScene().getWindow().hide();
            cp.window("units.fxml", 335, 335, "units");
        });
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Product> searchProduct = new FilteredList<>(products);
            System.out.println(searchField.getText().trim());
            searchProduct.setPredicate(product -> {
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               String lowerCase = newValue.toLowerCase();
               if(product.getNameProduct().toLowerCase().contains(lowerCase)){return true;}
               else if (String.valueOf(product.getIdProduct()).contains(lowerCase)) {return true;}
               else if (String.valueOf(product.getIdUnits()).contains(lowerCase)) {return true;}
               else if (String.valueOf(product.getCountWare()).contains(lowerCase)) {return true;}
               else return product.getDescription().toLowerCase().contains(lowerCase);
            });
            productTable.setItems(searchProduct);
        });
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> cp.window("addProduct.fxml", 300, 400, "addProduct"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteProduct.fxml", 148, 200, "delete"));
    }
    public void update(){
        products.clear();
        String update = "SELECT * FROM products";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(update);
            while (rs.next()){
                int id = rs.getInt("idProduct");
                String name = rs.getString("nameProduct");
                int idOfUnits = rs.getInt("idUnits");
                int count = rs.getInt("countWare");
                String des = rs.getString("description");

                Product product = new Product(id, name, idOfUnits, count, des);
                products.add(product);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        productTable.setItems(products);
    }
    private void initDate() {

        String query = "SELECT * FROM products";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("idProduct");
                String name = rs.getString("nameProduct");
                int idOfUnits = rs.getInt("idUnits");
                int count = rs.getInt("countWare");
                String des = rs.getString("description");

                Product product = new Product(id, name, idOfUnits, count, des);
                products.add(product);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        TableColumn<Product, Integer> idProduct = new TableColumn<>("Id_product");
        idProduct.setCellValueFactory(new PropertyValueFactory<>("idProduct"));

        TableColumn<Product, String> nameProduct = new TableColumn<>("name_Product");
        nameProduct.setCellValueFactory(new PropertyValueFactory<>("nameProduct"));

        TableColumn<Product, Integer> idUnits = new TableColumn<>("Id_Unit");
        idUnits.setCellValueFactory(new PropertyValueFactory<>("idUnits"));

        TableColumn<Product, Integer> countWare = new TableColumn<>("count_ware");
        countWare.setCellValueFactory(new PropertyValueFactory<>("countWare"));

        TableColumn<Product, String> description = new TableColumn<>("description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        productTable.getColumns().addAll(idProduct, nameProduct, idUnits, countWare, description);

        productTable.setItems(products);
    }
}