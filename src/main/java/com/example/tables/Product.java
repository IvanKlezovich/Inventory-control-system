package com.example.tables;

import java.util.Objects;

public class Product {
    private int idProduct;
    private String nameProduct;
    private int idUnits;
    private int countWare;
    private String description;
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public int getIdUnits() {
        return idUnits;
    }
    public void setIdUnits(int idUnits) {
        this.idUnits = idUnits;
    }
    public int getCountWare() {
        return countWare;
    }
    public void setCountWare(int countWare) {
        this.countWare = countWare;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getIdProduct() == product.getIdProduct() && getIdUnits() == product.getIdUnits() && getCountWare() == product.getCountWare() && Objects.equals(getNameProduct(), product.getNameProduct()) && Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduct(), getNameProduct(), getIdUnits(), getCountWare(), getDescription());
    }

    public Product() {}
    public Product(String nameProduct, int idUnits, int countWare, String description) {
        this.nameProduct = nameProduct;
        this.idUnits = idUnits;
        this.countWare = countWare;
        this.description = description;
    }
    public Product(int idProduct, String nameProduct, int idUnits, int countWare, String description) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.idUnits = idUnits;
        this.countWare = countWare;
        this.description = description;
    }
}
