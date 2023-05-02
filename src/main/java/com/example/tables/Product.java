package com.example.tables;

public class Product {
    private int idOfProduct;
    private String nameOfProduct;
    private String idOfEnum;
    private int countOfWare;
    private String description;

    public int getIdOfProduct() {
        return idOfProduct;
    }
    public void setIdOfProduct(int idOfProduct) {
        this.idOfProduct = idOfProduct;
    }
    public String getNameOfProduct() {
        return nameOfProduct;
    }
    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }
    public String getIdOfEnum() {
        return idOfEnum;
    }
    public void setIdOfEnum(String idOfEnum) {
        this.idOfEnum = idOfEnum;
    }
    public int getCountOfWare() {
        return countOfWare;
    }
    public void setCountOfWare(int countOfWare) {
        this.countOfWare = countOfWare;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Product() {
    }
    public Product(int idOfProduct, String nameOfProduct, String idOfEnum, int countOfWare, String description) {
        this.idOfProduct = idOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.idOfEnum = idOfEnum;
        this.countOfWare = countOfWare;
        this.description = description;
    }
}