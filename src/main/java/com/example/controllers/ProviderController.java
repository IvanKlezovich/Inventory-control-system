package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Provider;
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

public class ProviderController implements Const {
    private final ObservableList<Provider> providers = FXCollections.observableArrayList();
    CurseProject cp = new CurseProject();
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button CloseProviderButton;
    @FXML
    private TableView<Provider> providerTable;
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
        CloseProviderButton.setOnAction(actionEvent -> {
            CloseProviderButton.getScene().getWindow().hide();
            cp.window("product.fxml", 720, 635, "product");
        });
        searchField.textProperty().addListener((observableValue, newValue, oldValue) -> {
            FilteredList<Provider> searchProvider = new FilteredList<>(providers);
            System.out.println(searchField.getText().trim());
            searchProvider.setPredicate(provider -> {
                if(newValue == null || newValue.isEmpty()){return true;}
                String lowerCase = newValue.toLowerCase();
                if(String.valueOf(provider.getIdProvider()).contains(lowerCase)) return true;
                else if(provider.getAddress().toLowerCase().contains(lowerCase)) return true;
                else if(provider.getFIO().toLowerCase().contains(lowerCase)) return true;
                else if(provider.getNumberPhone().toLowerCase().contains(lowerCase)) return true;
                else return (String.valueOf(provider.getNumberPhone()).contains(lowerCase));

            });
            providerTable.setItems(searchProvider);
        });
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> cp.window("addProvider.fxml", 300, 400, "addProvider"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteProvider.fxml", 148, 200, "delete"));
    }
    public void update(){
        providers.clear();
        String update = "SELECT * FROM " + Const.PROVIDER_TABLE + ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(update);
            while (rs.next()){
                int idProvider = rs.getInt(Const.PROVIDER_ID);
                String FIO = rs.getString(Const.PROVIDER_FIO);
                String numberPhone = rs.getString(Const.PROVIDER_NUMBER_PHONE);
                String address = rs.getString(Const.PROVIDER_ADDRESS);
                int numberOfAccount = rs.getInt(Const.PROVIDER_NUMBER_ACCOUNT);

                Provider provider = new Provider(idProvider, FIO, numberPhone, address, numberOfAccount);
                providers.add(provider);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        providerTable.setItems(providers);
    }
    private void initDate() {
        String query = "SELECT * FROM " + Const.PROVIDER_TABLE+ ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int idProvider = rs.getInt(Const.PROVIDER_ID);
                String FIO = rs.getString(Const.PROVIDER_FIO);
                String numberPhone = rs.getString(Const.PROVIDER_NUMBER_PHONE);
                String address = rs.getString(Const.PROVIDER_ADDRESS);
                int numberOfAccount = rs.getInt(Const.PROVIDER_NUMBER_ACCOUNT);

                Provider provider = new Provider(idProvider, FIO, numberPhone, address, numberOfAccount);
                providers.add(provider);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        TableColumn<Provider, Integer> idOfProvider = new TableColumn<>("Id_provider");
        idOfProvider.setCellValueFactory(new PropertyValueFactory<>("idProvider"));

        TableColumn<Provider, String> FIO = new TableColumn<>("FIO");
        FIO.setCellValueFactory(new PropertyValueFactory<>("FIO"));

        TableColumn<Provider, String> numberPhone = new TableColumn<>("number_phone");
        numberPhone.setCellValueFactory(new PropertyValueFactory<>("numberPhone"));

        TableColumn<Provider, String> address = new TableColumn<>("address");
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Provider, Integer> numberAccount = new TableColumn<>("number_account");
        numberAccount.setCellValueFactory(new PropertyValueFactory<>("numberOfAccount"));

        providerTable.getColumns().addAll(idOfProvider, FIO, numberPhone, address, numberAccount);

        providerTable.setItems(providers);
    }
}