package com.example.tables;

public class Provider {
    private int idProvider;
    private String FIO;
    private String numberPhone;
    private String address;
    private int numberOfAccount;
    public int getIdProvider() {
        return idProvider;
    }
    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }
    public String getFIO() {
        return FIO;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public String getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getNumberOfAccount() {
        return numberOfAccount;
    }
    public void setNumberOfAccount(int numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }
    public Provider() {}
    public Provider(int idProvider, String FIO, String numberPhone, String address, int numberOfAccount) {
        this.idProvider = idProvider;
        this.FIO = FIO;
        this.numberPhone = numberPhone;
        this.address = address;
        this.numberOfAccount = numberOfAccount;
    }
}
