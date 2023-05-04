package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import com.example.tables.Units;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitsController implements Const {
    private final ObservableList<Units> units = FXCollections.observableArrayList();
    CurseProject cp = new CurseProject();
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
    void initialize(){
        initDate();
        CloseUnitsButton.setOnAction(actionEvent -> {
            CloseUnitsButton.getScene().getWindow().hide();
            cp.window("product.fxml", 720, 635, "product");
        });
        updateButton.setOnAction(actionEvent -> update());
        insertButton.setOnAction(actionEvent -> cp.window("addUnits.fxml", 170, 240, "add"));
        deleteButton.setOnAction(actionEvent -> cp.window("deleteUnits.fxml", 148, 200, "delete"));
    }
    public void update(){
        unitsTable.getItems().clear();
        String update = "SELECT * FROM " + Const.UNITS_TABLE + ";";

        try{
            ResultSet rs = db.getDbconnection().createStatement().executeQuery(update);
            while (rs.next()){
                int id = rs.getInt(Const.ID_UNITS);
                String name = rs.getString(Const.NAME_UNITS);

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
                int id = rs.getInt(Const.ID_UNITS);
                String name = rs.getString(Const.NAME_UNITS);

                Units unit = new Units(id, name);
                units.add(unit);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        TableColumn<Units, Integer> idOfProduct = new TableColumn<>("Id_units");
        idOfProduct.setCellValueFactory(new PropertyValueFactory<>("idOfUnit"));

        TableColumn<Units, String> nameOfProduct = new TableColumn<>("name_Unit");
        nameOfProduct.setCellValueFactory(new PropertyValueFactory<>("nameUnit"));

        unitsTable.getColumns().addAll(idOfProduct, nameOfProduct);

        unitsTable.setItems(units);
    }
}
