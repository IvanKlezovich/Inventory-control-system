package com.example.connection;

public interface Const {
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "admin";
    String dbPass = "12345";
    String dbName = "curse";

    String ORDER_TABLE = "order";
    String  ID_ORDER = "idOfOrder";
    String  ID_PROVIDER = "idProvider";
    String COUNT_ORDER = "countOfOrder";
    String ORDER_PRISE = "prise";
    String AMOUNT_ORDER = "amountOfOrder";
    String ORDER_DELIVERY_TIME = "deliveryTime";

    String PRODUCTS_TABLE = "products";
    String ID_PRODUCT = "idOfProduct";
    String NAME_PRODUCT = "nameOfProduct";
    String ID_ENUM = "idOfEnum";
    String COUNT_WARE = "countOfWare";
    String DESCRIPTION = "description";

    String PROVIDER_TABLE = "provider";
    String PROVIDER_ID = "idProvider";
    String PROVIDER_FIO = "FIO";
    String PROVIDER_NUMBER_PHONE = "numberOfPhone";
    String PROVIDER_ADDRESS = "address";
    String PROVIDER_NUMBER_ACCOUNT = "numberOfAccount";

    String UNITS_TABLE = "units";
    String ID_UNITS = "idOfUnits";
    String NAME_UNITS = "nameUnit";

    String USER_TABLE = "user";
    String USER_NAME = "userName";
    String USER_PASSWORD = "userPassword";
}
