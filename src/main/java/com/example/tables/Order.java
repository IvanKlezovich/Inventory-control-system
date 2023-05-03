package com.example.tables;

import java.sql.Time;

public class Order {
    private int idOrder;
    private int idProvider;
    private int countOfProvider;
    private int prise;
    private int amountOfOrder;
    private Time deliveryTime;
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
    public int getCountOfProvider() {
        return countOfProvider;
    }
    public void setCountOfProvider(int countOfProvider) {
        this.countOfProvider = countOfProvider;
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
    public Time getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public Order() {}
    public Order(int idOrder, int idProvider, int countOfProvider, int prise, int amountOfOrder, Time deliveryTime) {
        this.idOrder = idOrder;
        this.idProvider = idProvider;
        this.countOfProvider = countOfProvider;
        this.prise = prise;
        this.amountOfOrder = amountOfOrder;
        this.deliveryTime = deliveryTime;
    }
}
