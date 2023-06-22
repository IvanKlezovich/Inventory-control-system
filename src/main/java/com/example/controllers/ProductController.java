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

public class ProductController {
    private final ObservableList<Product> products = FXCollections.observableArrayList();
    private final CurseProject cp = new CurseProject();
    private final DatabaseHandler db = new DatabaseHandler();
    @FXML
    private TableView<Product> productTable;
    @FXML
    private Button changeButton;
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
            cp.window("order.fxml", 687, 720, "order");
        });
        OpenProviderButton.setOnAction(actionEvent -> {
            OpenProviderButton.getScene().getWindow().hide();
            cp.window("provider.fxml", 720, 719, "provider");
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
        insertButton.setOnAction(actionEvent -> cp.window("addProduct.fxml", 400, 300, "addProduct"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteProduct.fxml", 200, 148, "delete"));
        changeButton.setOnAction(actionEvent -> cp.window("changeProduct.fxml", 600, 400, "change"));
    }
    public void update(){
        products.clear();

        products.addAll(db.initializationTable("product"));

        productTable.setItems(products);
    }
    private void initDate() {

        products.addAll(db.initializationTable("product"));

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