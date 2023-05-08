package com.example.tables;

public class Units{
    private int idUnit;
    private String nameUnit;
    public int getIdUnit() {
        return idUnit;
    }
    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
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
    public Units(int idUnit, String nameUnit) {
        this.idUnit = idUnit;
        this.nameUnit = nameUnit;
    }
}
