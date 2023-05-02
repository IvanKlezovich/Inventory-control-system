package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductController {
    private Product product = new Product();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private final CurseProject cp = new CurseProject();
    private DatabaseHandler db = new DatabaseHandler();

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
        //productTable.setItems(products);
        OpenOrderButton.setOnAction(actionEvent -> {
           OpenOrderButton.getScene().getWindow().hide();
            try{
                cp.order();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        OpenProviderButton.setOnAction(actionEvent -> {
            OpenProviderButton.getScene().getWindow().hide();
            try{
                cp.provider();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        OpenUnitsButton.setOnAction(actionEvent -> {
            OpenUnitsButton.getScene().getWindow().hide();
            try{
                cp.units();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    private void initDate() {
        /*idOfProduct.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id_product"));
        nameOfProduct.setCellValueFactory(new PropertyValueFactory<Product, String>("name_product"));
        idOfEnum.setCellValueFactory(new PropertyValueFactory<Product, String>("id_enum"));
        countOfWare.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count_ware"));
        description.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));

        ResultSet rs =  db.getProduct(product);
        try{
            while (rs.next()){
                int id = rs.getInt("idOfProduct");
                String name = rs.getString("nameOfProduct");
                String idEnum = rs.getString("idOfEnum");
                int count = rs.getInt("countOfWare");
                String des = rs.getString("description");

                Product product = new Product(id, name, idEnum, count, des);

                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }*/
    }
}
