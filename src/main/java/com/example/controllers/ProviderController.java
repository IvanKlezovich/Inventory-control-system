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
    private Button changeButton;
    @FXML
    void initialize(){
        initDate();
        CloseProviderButton.setOnAction(actionEvent -> {
            CloseProviderButton.getScene().getWindow().hide();
            cp.window("product.fxml", 635, 720, "product");
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
        changeButton.setOnAction(actionEvent -> cp.window("changeProvider.fxml", 600, 329, " "));
        insertButton.setOnAction(actionEvent -> cp.window("addProvider.fxml", 400, 300, "addProvider"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteProvider.fxml", 200, 148, "delete"));
    }
    public void update(){
        providers.clear();

        providers.addAll(db.initializationTable("provider"));

        providerTable.setItems(providers);
    }
    private void initDate() {

        providers.addAll(db.initializationTable("provider"));

        TableColumn<Provider, Integer> idOfProvider = new TableColumn<>("Id_provider");
        idOfProvider.setCellValueFactory(new PropertyValueFactory<>("idProvider"));

        TableColumn<Provider, String> FIO = new TableColumn<>("FIO");
        FIO.setCellValueFactory(new PropertyValueFactory<>("FIO"));

        TableColumn<Provider, String> numberPhone = new TableColumn<>("number_phone");
        numberPhone.setCellValueFactory(new PropertyValueFactory<>("numberPhone"));

        TableColumn<Provider, String> address = new TableColumn<>("address");
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Provider, Integer> numberAccount = new TableColumn<>("number_account");
        numberAccount.setCellValueFactory(new PropertyValueFactory<>("numberAccount"));

        providerTable.getColumns().addAll(idOfProvider, FIO, numberPhone, address, numberAccount);

        providerTable.setItems(providers);
    }
}