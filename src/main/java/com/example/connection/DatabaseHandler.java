package com.example.connection;

import com.example.tables.*;
import java.sql.*;

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

    public ResultSet getUser(User user){
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_NAME +  "=? AND " +
                Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement psSt =
                    getDbconnection().prepareStatement(select);
            psSt.setString(1, user.getName());
            psSt.setString(2, user.getPassword());

            resultSet = psSt.executeQuery();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resultSet;
    }
    public void singUpUser(User user){
        String insert = "INSERT " + Const.USER_TABLE + "("
                + Const.USER_NAME + "," + Const.USER_PASSWORD + ")"
                + "VALUES(?,?);";
        try {
            PreparedStatement psSt =
                    getDbconnection().prepareStatement(insert);
            psSt.setString(1, user.getName());
            psSt.setString(2, user.getPassword());

            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
    public void addProduct(Product product){
        String insert = "INSERT " + Const.PRODUCTS_TABLE + "(" +
                Const.NAME_PRODUCT + "," + Const.ID_ENUM + "," +
                Const.COUNT_WARE + "," + Const.DESCRIPTION + ")"
                + "VALUES(?,?,?,?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setString(1, product.getNameOfProduct());
            psSt.setString(2, product.getIdOfEnum());
            psSt.setInt(3, product.getCountOfWare());
            psSt.setString(4, product.getDescription());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addProvider(Provider provider){
        String insert = "INSERT " + Const.PRODUCTS_TABLE + "(" +
                Const.PROVIDER_FIO + "," + Const.PROVIDER_NUMBER_PHONE + "," +
                Const.PROVIDER_ADDRESS + "," + Const.PROVIDER_NUMBER_ACCOUNT + ")"
                + "VALUES(?,?,?,?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setString(1, provider.getFIO());
            psSt.setString(2, provider.getNumberPhone());
            psSt.setString(3, provider.getAddress());
            psSt.setInt(4, provider.getNumberOfAccount());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addOrder(Order order){
        String insert = "INSERT " + Const.ORDER_TABLE + "(" +
                Const.ID_ORDER + "," + Const.COUNT_ORDER + "," +
                Const.ORDER_PRISE + "," + Const.AMOUNT_ORDER + ","
                + Const.ORDER_DELIVERY_TIME + ")"
                + "VALUES(?,?,?,?,?);";
        try{
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.setInt(1, order.getIdProvider());
            psSt.setInt(2, order.getCountOfProvider());
            psSt.setInt(3, order.getPrise());
            psSt.setInt(4, order.getPrise());
            psSt.setTime(5, order.getDeliveryTime());

            psSt.executeUpdate();
            psSt.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addUnits(Units units){
        String insert = "INSERT " + Const.UNITS_TABLE + "(" +
                Const.NAME_UNITS + ")"
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
                " WHERE " + Const.ID_PRODUCT + " = " + number + ";";
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
                " WHERE " + Const.ID_PROVIDER + " = " + number + ";";
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
                " WHERE " + Const.ID_ORDER + " = " + number + ";";
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
                " WHERE " + Const.ID_UNITS  + " = " + number + ";";
        try {
            PreparedStatement ps = getDbconnection().prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}