package com.example.connection;

public interface Const {
    String dbHost = "localhost";
    String dbPort = "3306";
    String dbUser = "admin";
    String dbPass = "123456";
    String dbName = "Curse";

    String ORDER_TABLE = "order";
    String  ID_ORDER = "idoOrder";
    String  ID_PROVIDER = "idProvider";
    String COUNT_ORDER = "countOfOrder";
    String PRISE = "prise";
    String AMOUNT_ORDER = "amountOfOrder";
    String DELIVERY_TIME = "deliveryTime";

    String PRODUCTS_TABLE = "products";
    String ID_PRODUCT = "idOfProduct";
    String NAME_PRODUCT = "nameOfProduct";
    String ID_ENUM = "idOfEnum";
    String COUNT_WARE = "countOfWare";
    String DESCRIPTION = "description";

    String PROVIDER_TABLE = "provider";
    String FIO = "FIO";
    String NUMBER_PHONE = "numberPhone";
    String ADDRESS = "address";
    String NUMBER_ACCOUNT = "numberOfAccount";

    String UNITS_TABLE = "units";
    String ID_UNITS = "idunits";
    String UNITS = "unit";

    String USER_TABLE = "user";
    String ID_USER = "iduser";
    String USER_NAME = "userName";
    String USER_PASSWORD = "userPassword";
}
