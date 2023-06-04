package com.example.connection;
/**This interface for const's.
 * @author Klezovich Ivan
 * @version 1.2*/
public interface Const {
    /**This block for connect database to application.*/
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "admin";
    String dbPass = "12345";
    String dbName = "curse";
    /**This block of const's for edit and add contents in table.
    * ORDER_TABLE name of table*/
    String ORDER_TABLE = "orders";
    /** ORDER_ID name of column in application and idOrder - name in database*/
    String ORDER_ID = "idOrder";
    /** ORDER_PRISE name of column in application and prise - name in database*/
    String ORDER_PRISE = "prise";
    /** ORDER_AMOUNT name of column in application and idOrder - name in database*/
    String ORDER_AMOUNT = "amountOrder";
    /** ORDER_DELIVERY_TIME name of column in application and idOrder - name in database*/
    String ORDER_DELIVERY_TIME = "deliveryTime";
    /**This block of const's for edit and add contents in table.
     * PRODUCTS_TABLE name of table*/
    String PRODUCTS_TABLE = "products";
    /** PRODUCT_ID name of column in application and products - name in database*/
    String PRODUCT_ID = "idProduct";
    /** PRODUCT_NAME name of column in application and nameProduct - name in database*/
    String PRODUCT_NAME = "nameProduct";
    /** PRODUCT_COUNT_WARE name of column in application and countWare - name in database*/
    String PRODUCT_COUNT_WARE = "countWare";
     /** PRODUCT_DESCRIPTION name of column in application and description - name in database*/
    String PRODUCT_DESCRIPTION = "description";
    /**This block of const's for edit and add contents in table.
     * PROVIDER_TABLE name of table*/
    String PROVIDER_TABLE = "provider";
    /** PROVIDER_ID name of column in application and idProvider - name in database*/
    String PROVIDER_ID = "idProvider";
    /** PROVIDER_FIO name of column in application and FIO - name in database*/
    String PROVIDER_FIO = "FIO";
    /** PROVIDER_NUMBER_PHONE name of column in application and numberPhone - name in database*/
    String PROVIDER_NUMBER_PHONE = "numberPhone";
    /** PROVIDER_ADDRESS name of column in application and address - name in database*/
    String PROVIDER_ADDRESS = "address";
    /** PROVIDER_NUMBER_ACCOUNT name of column in application and numberAccount - name in database*/
    String PROVIDER_NUMBER_ACCOUNT = "numberAccount";
    /** This block of const's for edit and add contents in table
     * UNITS_TABLE name of table in application, in database units*/
    String UNITS_TABLE = "units";
     /** UNITS_ID name of column in application, in database idUnits*/
    String UNITS_ID = "idUnits";
    /** UNITS_NAME name of column in application, in database nameUnits*/
    String UNITS_NAME = "nameUnits";
    /**This block of const's for edit and add contents in table.
     * USER_TABLE name of table in application, in database user*/
    String USER_TABLE = "user";
    /** USER_NAME name of column in application, in database userName*/
    String USER_NAME = "userName";
    /** USER_PASSWORD name of column in application, in database userPassword*/
    String USER_PASSWORD = "userPassword";
    /** USER_AUTHORISATION name of column in application, in database userAuth*/
    String USER_AUTHORIZATION = "userAuth";
    /** USER_ID name of column in application, in database userId*/
    String USER_ID = "userId";
}
