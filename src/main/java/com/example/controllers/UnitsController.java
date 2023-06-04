package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Units;
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

public class UnitsController implements Const {
    private final ObservableList<Units> units = FXCollections.observableArrayList();
    CurseProject curseProject = new CurseProject();
    DatabaseHandler db = new DatabaseHandler();
    @FXML
    private Button CloseUnitsButton;
    @FXML
    private TableView<Units> unitsTable;
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
        CloseUnitsButton.setOnAction(actionEvent -> {
            CloseUnitsButton.getScene().getWindow().hide();
            curseProject.window("product.fxml", 720, 635, "product");
        });
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredList<Units> searchProduct = new FilteredList<>(units);
            System.out.println(searchField.getText().trim());
            searchProduct.setPredicate(unit -> {
                if(newValue == null || newValue.isEmpty()) return true;
                String lowerCase = newValue.toLowerCase();
                if(String.valueOf(unit.getIdUnit()).contains(lowerCase)) return true;
                else return unit.getNameUnit().toLowerCase().contains(lowerCase);
            });
            unitsTable.setItems(searchProduct);
        });
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> curseProject.window("addUnits.fxml", 170, 240, "add"));
        deleteButton.setOnAction(actionEvent -> curseProject.window("deleteUnits.fxml", 148, 200, "delete"));
    }
    public void update(){
        units.clear();
        String update = "SELECT * FROM " + Const.UNITS_TABLE + ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(update);
            while (rs.next()){
                int id = rs.getInt(Const.UNITS_ID);
                String name = rs.getString(Const.UNITS_NAME);

                Units unit = new Units(id, name);
                units.add(unit);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        unitsTable.setItems(units);
    }
    private void initDate() {

        String update = "SELECT * FROM " + Const.UNITS_TABLE + ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(update);
            while (rs.next()){
                int id = rs.getInt(Const.UNITS_ID);
                String name = rs.getString(Const.UNITS_NAME);

                Units unit = new Units(id, name);
                units.add(unit);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        TableColumn<Units, Integer> idUnits = new TableColumn<>("Id_units");
        idUnits.setCellValueFactory(new PropertyValueFactory<>("idUnit"));

        TableColumn<Units, String> nameUnits = new TableColumn<>("name_Unit");
        nameUnits.setCellValueFactory(new PropertyValueFactory<>("nameUnit"));

        unitsTable.getColumns().addAll(idUnits, nameUnits);

        unitsTable.setItems(units);
    }
}
