package com.example.connection;

import com.example.tables.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler implements Const{
    Connection dbconnection;
    public Connection getDbconnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + Const.dbHost +
                ":" + Const.dbPort + "/" + Const.dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbconnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbconnection;
    }
    public void singUpUser(User user, boolean auth){
        String insert = "INSERT " + Const.USER_TABLE + "("
                + Const.USER_NAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_AUTHORIZATION + ")"
                + "VALUES(?,?,?);";
        try {
            PreparedStatement psSt =
                    getDbconnection().prepareStatement(insert);
            psSt.setString(1, user.getName());
            psSt.setString(2, user.getPassword());
            psSt.setBoolean(3, auth);

            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
    public void addProduct(Product product){
        String insert = "INSERT " + Const.PRODUCTS_TABLE + "(" +
                Const.PRODUCT_NAME + "," + Const.UNITS_ID + "," +
                Const.PRODUCT_COUNT_WARE + "," + Const.PRODUCT_DESCRIPTION + ")"
                + "VALUES(?,?,?,?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setString(1, product.getNameProduct());
            psSt.setInt(2, product.getIdUnits());
            psSt.setInt(3, product.getCountWare());
            psSt.setString(4, product.getDescription());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addProvider(Provider provider){
        String insert = "INSERT " + Const.PROVIDER_TABLE + "(" +
                Const.PROVIDER_FIO + "," + Const.PROVIDER_NUMBER_PHONE + "," +
                Const.PROVIDER_ADDRESS + "," + Const.PROVIDER_NUMBER_ACCOUNT + ")"
                + "VALUES(?,?,?,?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setString(1, provider.getFIO());
            psSt.setString(2, provider.getNumberPhone());
            psSt.setString(3, provider.getAddress());
            psSt.setInt(4, provider.getNumberAccount());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addOrder(Order order){
        String insert = "INSERT " + Const.ORDER_TABLE + "(" +
                Const.PROVIDER_ID + "," + Const.PRODUCT_ID + "," +
                Const.ORDER_PRISE + "," + Const.ORDER_AMOUNT + ","
                + Const.ORDER_DELIVERY_TIME + ")"
                + "VALUES(?,?,?,?,?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setInt(1, order.getIdProvider());
            psSt.setInt(2, order.getIdProduct());
            psSt.setInt(3, order.getPrise());
            psSt.setInt(4, order.getAmountOfOrder());
            psSt.setString(5, order.getDeliveryTime());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addUnits(Units units){
        String insert = "INSERT " + Const.UNITS_TABLE + "(" +
                Const.UNITS_NAME + ")"
                + "VALUES(?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setString(1, units.getNameUnit());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void delProduct(int number){
        String delete = "DELETE FROM " + Const.PRODUCTS_TABLE +
                " WHERE " + Const.PRODUCT_ID + " = " + number + ";";
        try {
            PreparedStatement ps = getDbconnection().prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void delProvider(int number){
        String delete = "DELETE FROM " + Const.PROVIDER_TABLE +
                " WHERE " + Const.PROVIDER_ID + " = " + number + ";";
        try {
            PreparedStatement ps = getDbconnection().prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void delOrder(int number){
        String delete = "DELETE FROM " + Const.ORDER_TABLE +
                " WHERE " + Const.ORDER_ID + " = " + number + ";";
        try {
            PreparedStatement ps = getDbconnection().prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void delUnits(int number){
        String delete = "DELETE FROM " + Const.UNITS_TABLE +
                " WHERE " + Const.UNITS_ID + " = " + number + ";";
        try {
            PreparedStatement ps = getDbconnection().prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}