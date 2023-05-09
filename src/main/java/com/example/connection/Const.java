package com.example.connection;

public interface Const {
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "admin";
    String dbPass = "12345";
    String dbName = "curse";

    String ORDER_TABLE = "orders";
    String ORDER_ID = "idOrder";
    String ORDER_PRISE = "prise";
    String ORDER_AMOUNT = "amountOrder";
    String ORDER_DELIVERY_TIME = "deliveryTime";

    String PRODUCTS_TABLE = "products";
    String PRODUCT_ID = "idProduct";
    String PRODUCT_NAME = "nameProduct";
    String PRODUCT_COUNT_WARE = "countWare";
    String PRODUCT_DESCRIPTION = "description";

    String PROVIDER_TABLE = "provider";
    String PROVIDER_ID = "idProvider";
    String PROVIDER_FIO = "FIO";
    String PROVIDER_NUMBER_PHONE = "numberPhone";
    String PROVIDER_ADDRESS = "address";
    String PROVIDER_NUMBER_ACCOUNT = "numberAccount";

    String UNITS_TABLE = "units";
    String UNITS_ID = "idUnits";
    String UNITS_NAME = "nameUnits";

    String USER_TABLE = "user";
    String USER_NAME = "userName";
    String USER_PASSWORD = "userPassword";
    String USER_AUTHORIZATION = "userAuth";
}
