package com.example.connection;
/**
 * This interface for const's.
 * @author Klezovich Ivan
 * @version 1.2
 */
public interface Const {
    /**
     * this block for connect database to application.
     */
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "admin";
    String dbPass = "12345";
    String dbName = "curse";
    /**
     * This block of const's for edit and add contents in table.
     * ORDER_TABLE name of table
     * ORDER_ID name of column in application and idOrder - name in database
     * ORDER_PRISE name of column in application and idOrder - name in database
     * ORDER_AMOUNT name of column in application and idOrder - name in database
     * ORDER_DELIVERY_TIME name of column in application and idOrder - name in database
     * ORDER_ID name of column in application and idOrder - name in database
     */
    String ORDER_TABLE = "orders";
    String ORDER_ID = "idOrder";
    String ORDER_PRISE = "prise";
    String ORDER_AMOUNT = "amountOrder";
    String ORDER_DELIVERY_TIME = "deliveryTime";
    /**
     * This block of const's for edit and add contents in table.
     * PRODUCTS_TABLE name of table
     * PRODUCT_ID name of column in application and products - name in database
     * PRODUCT_NAME name of column in application and nameProduct - name in database
     * PRODUCT_COUNT_WARE name of column in application and countWare - name in database
     * PRODUCT_DESCRIPTION name of column in application and description - name in database
     */
    String PRODUCTS_TABLE = "products";
    String PRODUCT_ID = "idProduct";
    String PRODUCT_NAME = "nameProduct";
    String PRODUCT_COUNT_WARE = "countWare";
    String PRODUCT_DESCRIPTION = "description";
    /**
     * This block of const's for edit and add contents in table.
     * PROVIDER_TABLE name of table
     * PROVIDER_ID name of column in application and idProvider - name in database
     * PROVIDER_FIO name of column in application and FIO - name in database
     * PROVIDER_NUMBER_PHONE name of column in application and numberPhone - name in database
     * PROVIDER_ADDRESS name of column in application and address - name in database
     * PROVIDER_NUMBER_ACCOUNT name of column in application and numberAccount - name in database
     */
    String PROVIDER_TABLE = "provider";
    String PROVIDER_ID = "idProvider";
    String PROVIDER_FIO = "FIO";
    String PROVIDER_NUMBER_PHONE = "numberPhone";
    String PROVIDER_ADDRESS = "address";
    String PROVIDER_NUMBER_ACCOUNT = "numberAccount";
    /**
     * This block of const's for edit and add contents in table
     * UNITS_TABLE name of table in application, in database units
     * UNITS_ID name of column in application, in database idUnits
     * UNITS_NAME name of column in application, in database nameUnits
     */
    String UNITS_TABLE = "units";
    String UNITS_ID = "idUnits";
    String UNITS_NAME = "nameUnits";
    /**
     * this block of const's for edit and add contents in table.
     * USER_TABLE name of table in application, in database user
     * USER_NAME name of column in application, in database userName
     * USER_PASSWORD name of column in application, in database userPassword
     * USER_AUTHORISATION name of column in application, in database userAuth
     * USER_ID name of column in application, in database userId
     */
    String USER_TABLE = "user";
    String USER_NAME = "userName";
    String USER_PASSWORD = "userPassword";
    String USER_AUTHORIZATION = "userAuth";
    String USER_ID = "userId";
}
