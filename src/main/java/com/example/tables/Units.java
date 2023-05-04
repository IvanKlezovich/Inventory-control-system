package com.example.tables;

public class Units{
    private int idOfUnit;
    private String nameUnit;
    public int getIdOfUnit() {
        return idOfUnit;
    }
    public void setIdOfUnit(int idOfUnit) {
        this.idOfUnit = idOfUnit;
    }
    public String getNameUnit() {
        return nameUnit;
    }
    public void setNameUnit(String nameUnit) {
        this.nameUnit = nameUnit;
    }
    public Units() {}

    public Units(String nameUnit){
        this.nameUnit = nameUnit;
    }
    public Units(int idOfUnit, String nameUnit) {
        this.idOfUnit = idOfUnit;
        this.nameUnit = nameUnit;
    }
}
