package com.example.connection;

import com.example.tables.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

/**This class create connection to database and for edit database file.
 * @author  Klezovich Ivan
 * @version 1.5
 */

public class DatabaseHandler implements Const{
    Connection dbconnection;

    /**
     * This method for create connection and test them.
     * @return connection.
     * @throws ClassNotFoundException e
     * @throws SQLException e
     */

    public Connection getDbconnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + Const.dbHost +
                ":" + Const.dbPort + "/" + Const.dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbconnection;
    }

    /**
     * This method for add users to table of users.
     * @param user people with some parameters.
     */

    private void singUpUser(User user){
        String insert = "INSERT " + Const.USER_TABLE + "("
                + Const.USER_NAME + "," + Const.USER_PASSWORD + "," +
                Const.USER_AUTHORIZATION + ")"
                + "VALUES(?,?,?);";
        try {
            PreparedStatement psSt =
                    getDbconnection().prepareStatement(insert);
            psSt.setString(1, user.getName());
            psSt.setString(2, user.getPassword());
            psSt.setBoolean(3, false);

            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * This method for add products with some parameters.
     * @param product product with some parameters.
     */

    private void addProduct(Product product){
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

    /**
     * This method for add provider in list of providers in database.
     * @param provider provider with some parameters.
     */

    private void addProvider(Provider provider){
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

    /**
     * This method for add orders in list of orders in database.
     * @param order order with some parameters
     */

    private void addOrder(Order order){
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

    /**
     * This method for add units in list of orders in database.
     * @param units units with some parameters
     */

    private void addUnits(Units units){
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

    /**
     * This method for delete product in database.
     * @param number number of deleting product
     */
    private void delProduct(int number){
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

    /**
     * This method for delete provider in database.
     * @param number number of deleting provider
     */

    private void delProvider(int number){
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

    /**
     * This method for delete order in database.
     * @param number number of deleting order
     */

    private void delOrder(int number){
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

    /**
     * This method for delete unit for this number in table.
     * @param number of deleting unit.
     */

    private void delUnits(int number){
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

    /**
     * Method for edit table product
     * @param product product{1, banana, 9, 15, no}
     */

    private void changeProduct(Product product){
        String updateProduct = "UPDATE " + Const.PRODUCTS_TABLE + " SET ";

        if(!(product.getNameProduct().equals(""))){
            if ((product.getIdUnits() == 0) && (product.getCountWare() == 0)
                    && (product.getDescription().equals(""))) {
                updateProduct += Const.PRODUCT_NAME + " = '" + product.getNameProduct() + "'";
            } else {
                updateProduct += Const.PRODUCT_NAME + " = '" + product.getNameProduct() + "', ";
            }
        }

        if(!(product.getIdUnits() == 0)){
            if((product.getCountWare() == 0) && (product.getDescription().equals(""))
                    && (product.getNameProduct().equals(""))){
                updateProduct += Const.UNITS_ID + " = '" + product.getIdUnits() + "'";
            }
            else {
                updateProduct += Const.UNITS_ID + " = '" + product.getIdUnits() + "', ";
            }
        }

        if(!(product.getCountWare() == 0)){
             if ((product.getDescription().equals("")) && (product.getIdUnits() == 0)
                     && (product.getNameProduct().equals(""))){
                updateProduct += Const.PRODUCT_COUNT_WARE + " = '" + product.getCountWare() + "'";
            }
            else{
                updateProduct += Const.PRODUCT_COUNT_WARE + " = '" + product.getCountWare() + "', ";
            }
        }

        if(!product.getDescription().equals("")) {
            updateProduct += Const.PRODUCT_DESCRIPTION + " = '" + product.getDescription() + "'";
        }

        updateProduct += " WHERE (" + Const.PRODUCT_ID + " = '" + product.getIdProduct() + "');";

        try {
            PreparedStatement psSt = getDbconnection().prepareStatement(updateProduct);
            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method for edit table provider
     * @param provider provider{1, Kleverov Nikolay Semenovich, +375291353003, st. qwerty 12, 123}
     */

    private void changeProvider(Provider provider){
        String updateProvider = "UPDATE " + Const.PROVIDER_TABLE + " SET ";

        if(!(provider.getFIO().equals(""))){
            if ((provider.getNumberPhone().equals("")) && (provider.getNumberAccount() == 0)
                    && (provider.getAddress().equals(""))) {
                updateProvider += Const.PROVIDER_FIO + " = '" + provider.getFIO() + "'";
            } else {
                updateProvider += Const.PROVIDER_FIO + " = '" + provider.getFIO() + "', ";
            }
        }

        if(!(provider.getNumberPhone().equals(""))){
            if((provider.getNumberAccount() == 0) && (provider.getFIO().equals(""))
                    && (provider.getAddress().equals(""))){
                updateProvider += Const.PROVIDER_NUMBER_PHONE + " = '" + provider.getNumberPhone() + "'";
            }
            else {
                updateProvider += Const.PROVIDER_NUMBER_PHONE + " = '" + provider.getNumberPhone() + "', ";
            }
        }

        if(!(provider.getNumberAccount() == 0)){
            if ((provider.getNumberPhone().equals("")) && (provider.getFIO().equals(""))
                    && (provider.getAddress().equals(""))){
                updateProvider += Const.PROVIDER_NUMBER_ACCOUNT + " = '" + provider.getNumberAccount() + "'";
            }
            else{
                updateProvider += Const.PROVIDER_NUMBER_ACCOUNT + " = '" + provider.getNumberAccount() + "', ";
            }
        }

        if(!provider.getAddress().equals("")) {
            updateProvider += Const.PROVIDER_ADDRESS + " = '" + provider.getAddress() + "'";
        }

        updateProvider += " WHERE (" + Const.PROVIDER_ID + " = '" + provider.getIdProvider() + "');";

        try {
            PreparedStatement psSt = getDbconnection().prepareStatement(updateProvider);
            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method for edit order
     * @param order order{1, 2, 3, 56, 89, no}
     */

    private void changeOrder(Order order){
        String updateOrder = "UPDATE " + Const.ORDER_TABLE + " SET ";

        if(!(order.getPrise() == 0)){
            if ((order.getAmountOfOrder() == 0) && (order.getIdProduct() == 0) && (order.getIdProvider() == 0)
                    && (order.getDeliveryTime().equals(""))) {
                updateOrder += Const.ORDER_PRISE + " = '" + order.getPrise() + "'";
            } else {
                updateOrder += Const.ORDER_PRISE + " = '" + order.getPrise() + "', ";
            }
        }

        if(!(order.getAmountOfOrder() == 0)){
            if((order.getIdProduct() == 0) && (order.getPrise() == 0) && (order.getIdProvider() == 0)
                    && (order.getDeliveryTime().equals(""))){
                updateOrder += Const.ORDER_AMOUNT + " = '" + order.getAmountOfOrder() + "'";
            }
            else {
                updateOrder += Const.ORDER_AMOUNT + " = '" + order.getAmountOfOrder() + "', ";
            }
        }

        if(!(order.getDeliveryTime().equals(""))){
            if ((order.getIdProduct() == 0) && (order.getAmountOfOrder() == 0) && (order.getPrise() == 0)
                    && (order.getIdProvider() == 0)){
                updateOrder += Const.PROVIDER_NUMBER_ACCOUNT + " = '" + order.getDeliveryTime() + "'";
            }
            else{
                updateOrder += Const.PROVIDER_NUMBER_ACCOUNT + " = '" + order.getDeliveryTime() + "', ";
            }
        }

        if(!(order.getIdProduct() == 0)){
            if ((order.getIdProduct() == 0) && (order.getAmountOfOrder() == 0) && (order.getPrise() == 0)
                    && (order.getIdProvider() == 0) && (order.getDeliveryTime().equals(""))){
                updateOrder += Const.PRODUCT_ID + " = '" + order.getIdProduct() + "'";
            }
            else{
                updateOrder += Const.PRODUCT_ID + " = '" + order.getIdProduct() + "', ";
            }
        }

        if(!(order.getIdProvider() == 0)) {
            updateOrder += Const.PROVIDER_ADDRESS + " = '" + order.getIdProvider() + "'";
        }

        updateOrder += " WHERE (" + Const.PROVIDER_ID + " = '" + order.getIdOrder() + "');";

        try {
            PreparedStatement psSt = getDbconnection().prepareStatement(updateOrder);
            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method for edit units
     * @param units units{2, "килограмм"}
     */

    private void changeUnits(Units units){
        String updateUnits = "UPDATE " + Const.UNITS_TABLE + " SET ";

        if(!units.getNameUnit().equals("")) {
            updateUnits += Const.UNITS_NAME + " = '" + units.getNameUnit() + "'";
        }

        updateUnits += " WHERE (" + Const.UNITS_ID + " = '" + units.getIdUnit() + "');";

        try {
            PreparedStatement psSt = getDbconnection().prepareStatement(updateUnits);
            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * This method for read products from database to program
     * @return list of product
     */

    private ObservableList<Product> initProduct(){

        ObservableList<Product> products = FXCollections.observableArrayList();

        String update = "SELECT * FROM products";

        try{
            ResultSet rs = getDbconnection().createStatement().executeQuery(update);
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
        return products;
    }

    /**
     * This method for read orders from database to program
     * @return list of orders
     */

    private ObservableList<Order> initOrder(){

        ObservableList<Order> orders = FXCollections.observableArrayList();

        String query = "SELECT * FROM " + Const.ORDER_TABLE + ";";

        try{
            ResultSet rs = getDbconnection().createStatement().executeQuery(query);
            while (rs.next()){
                int idOrder = rs.getInt(Const.ORDER_ID);
                int idProvider = rs.getInt(Const.PROVIDER_ID);
                int idProduct = rs.getInt(Const.PRODUCT_ID);
                int prise = rs.getInt(Const.ORDER_PRISE);
                int amountOfOrder = rs.getInt(Const.ORDER_AMOUNT);
                String deliveryTime = rs.getString(Const.ORDER_DELIVERY_TIME);

                Order order = new Order(idOrder, idProvider, idProduct, prise, amountOfOrder,deliveryTime);
                orders.add(order);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * This method for read providers from database to program
     * @return list of providers
     */

    private ObservableList<Provider> initProvider(){

        ObservableList<Provider> providers = FXCollections.observableArrayList();

        String update = "SELECT * FROM " + Const.PROVIDER_TABLE + ";";

        try{
            ResultSet rs = getDbconnection().createStatement().executeQuery(update);
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
        return providers;
    }

    /**
     * This method for read units from database to program
     * @return list of units
     */

    private ObservableList<Units> initUnits(){

        ObservableList<Units> units = FXCollections.observableArrayList();

        String update = "SELECT * FROM " + Const.UNITS_TABLE + ";";

        try{
            ResultSet rs = getDbconnection().createStatement().executeQuery(update);
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
        return units;
    }

    /**
     * This method for prove authorisation of users with some password and login.
     * @param logg login user
     * @param pass password of user
     * @return user authorization or no
     */

    public boolean isLog(String logg, String pass) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String message = "SELECT * FROM " + Const.USER_TABLE + ";";
        try (ResultSet rs = dbHandler.getDbconnection().createStatement().executeQuery(message)) {
            while (rs.next()) {
                String login = rs.getString(Const.USER_NAME);
                String password = rs.getString(Const.USER_PASSWORD);
                boolean auth = rs.getBoolean(Const.USER_AUTHORIZATION);
                if (auth && login.equals(logg) && password.equals(pass)) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method for choice table and number that we need to delete
     * @param scene table that we need to delete something
     * @param code number that we need to delete
     */

    public void choiceDelete(String scene, int code){
        switch(scene){
            case "product":{
                delProduct(code);
                break;
            }
            case "provider":{
                delProvider(code);
                break;
            }
            case "order":{
                delOrder(code);
                break;
            }
            case "units": {
                delUnits(code);
                break;
            }
            default:{

            }
        }
    }

    /**
     * This method for  units in database
     * @param nameDB name of database
     * @return amount of units in database
     */

    public int amountInDatabase(String nameDB){
        switch(nameDB){
            case "product":{
                return initProduct().size();
            }
            case "provider":{
                return initProvider().size();
            }
            case "order":{
                return initOrder().size();
            }
            case "units": {
                return initUnits().size();
            }
            default: return 0;
        }
    }

    /**
     * This method for initialize tables
     * @param nameBD name of table in database that we download to program
     * @return list with units.
     */

    public ObservableList initializationTable(String nameBD){
        ObservableList<Product> list = FXCollections.observableArrayList();

        switch(nameBD){
            case "product":{
                return initProduct();
            }
            case "provider":{
                return initProvider();
            }
            case "order":{
                return initOrder();
            }
            case "units": {
                return initUnits();
            }
            default: return list;
        }
    }

    /**
     * This method for choice table that we need to add unit
     * @param o - object for add
     * @param scene table that we need to add
     */

    public void choiceAdd(String scene, Object o){
        switch(scene){
            case "product":{
                addProduct((Product) o);
                break;
            }
            case "provider":{
                addProvider((Provider) o);
                break;
            }
            case "order":{
                addOrder((Order) o);
                break;
            }
            case "units": {
                addUnits((Units) o);
                break;
            }
            case "user":{
                singUpUser((User) o);
                break;
            }
            default:{
                break;
            }
        }
    }

    /**
     * This method for authorization people that create new account.
     * @param index index of note those we edit.
     */

    public void authUser(int index){
        String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_AUTHORIZATION
                + " = '1' WHERE (" + Const.USER_ID + " = '" + index + "');";
        try {
            PreparedStatement psSt = getDbconnection().prepareStatement(insert);
            psSt.executeUpdate();
            psSt.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Method for choosing table that we need to edit
     * @param scene table of editing
     * @param o object that edit
     */

    public void choiceChange(String scene, Object o){
        switch (scene){
            case "provider":{
                changeProvider((Provider) o);
                break;
            }
            case "product":{
                changeProduct((Product) o);
                break;
            }
            case "units":{
                changeUnits((Units) o);
                break;
            }
            case "order":{
                changeOrder((Order) o);
                break;
            }
            default:{

            }
        }
    }
}