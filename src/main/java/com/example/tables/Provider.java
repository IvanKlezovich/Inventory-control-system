package com.example.tables;

public class Provider {
    private int idProvider;
    private String FIO;
    private String numberPhone;
    private String address;
    private int numberAccount;
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
    public int getNumberAccount() {
        return numberAccount;
    }
    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }
    public Provider() {}
    public Provider(String FIO, String numberPhone, String address, int numberAccount){
        this.FIO = FIO;
        this.numberPhone = numberPhone;
        this.address = address;
        this.numberAccount = numberAccount;
    }
    public Provider(int idProvider, String FIO, String numberPhone, String address, int numberAccount) {
        this.idProvider = idProvider;
        this.FIO = FIO;
        this.numberPhone = numberPhone;
        this.address = address;
        this.numberAccount = numberAccount;
    }
}
