package com.example.tables;

public class Order {
    private int idOrder;
    private int idProvider;
    private int idProduct;
    private int prise;
    private int amountOfOrder;
    private String deliveryTime;
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    public int getIdProvider() {
        return idProvider;
    }
    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }
    public int getPrise() {
        return prise;
    }
    public void setPrise(int prise) {
        this.prise = prise;
    }
    public int getAmountOfOrder() {
        return amountOfOrder;
    }
    public void setAmountOfOrder(int amountOfOrder) {
        this.amountOfOrder = amountOfOrder;
    }
    public String getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public Order() {}
    public Order(int idProvider, int idProduct, int prise, int amountOfOrder, String deliveryTime) {
        this.idProvider = idProvider;
        this.idProduct = idProduct;
        this.prise = prise;
        this.amountOfOrder = amountOfOrder;
        this.deliveryTime = deliveryTime;
    }
    public Order(int idOrder, int idProvider, int idProduct, int prise, int amountOfOrder, String deliveryTime) {
        this.idOrder = idOrder;
        this.idProvider = idProvider;
        this.idProduct = idProduct;
        this.prise = prise;
        this.amountOfOrder = amountOfOrder;
        this.deliveryTime = deliveryTime;
    }
}
