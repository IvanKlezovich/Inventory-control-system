package com.example.connection;

import com.example.tables.Product;
import com.example.tables.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler implements Const{
    Connection dbconnection;

    public Connection getDbconnection() throws ClassNotFoundException,
            SQLException {
        String connectionString = "jdbc:mysql://" + Const.dbHost +
                ":" + Const.dbPort + "/" + Const.dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbconnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbconnection;
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
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public void setProduct(Product product){
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
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
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
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resultSet;
    }

}
