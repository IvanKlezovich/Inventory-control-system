package com.example.tables;
/**This class was being creating to make sample for set and get items to database.
 * @author Ivan Klezovich
 * @version 1.0*/
public class Provider {
    private int idProvider;
    private String FIO;
    private String numberPhone;
    private String address;
    private int numberAccount;
    /**This method for return id of provider.
     * @return idProvider
     */
    public int getIdProvider() {
        return idProvider;
    }
    /**This method for set id of provider
     * @param idProvider idProvider
     */
    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }
    /**This method for return FIO of provider.
     * @return FIO
     */
    public String getFIO() {
        return FIO;
    }
    /**This method for set FIO of provider
     * @param FIO FIO
     */
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    /**This method for return number hone of provider.
     * @return numberPhone
     */
    public String getNumberPhone() {
        return numberPhone;
    }
    /**This method for set number phone of provider
     * @param numberPhone numberPhone
     */
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    /**This method for return address of provider.
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**This method for set address of provider
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**This method for return id of provider.
     * @return idProvider
     */
    public int getNumberAccount() {
        return numberAccount;
    }
    /**This method for set number account of provider
     * @param numberAccount numberAccount
     */
    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }
    /** empty class for init.*/
    public Provider() {}
    /**This class for set new value in database
     * @param FIO Keleverov Nikolay Semenovich
     * @param numberPhone +375161353006
     * @param address ex. st. qwerty 12
     * @param numberAccount 123*/
    public Provider(String FIO, String numberPhone, String address, int numberAccount){
        this.FIO = FIO;
        this.numberPhone = numberPhone;
        this.address = address;
        this.numberAccount = numberAccount;
    }
    /**This class for view database units to tableview in form provider
     * @param idProvider ex. 12, 13, 89
     * @param FIO Keleverov Nikolay Semenovich
     * @param numberPhone +375161353006
     * @param address ex. st. qwerty 12
     * @param numberAccount 123*/
    public Provider(int idProvider, String FIO, String numberPhone, String address, int numberAccount) {
        this.idProvider = idProvider;
        this.FIO = FIO;
        this.numberPhone = numberPhone;
        this.address = address;
        this.numberAccount = numberAccount;
    }
}
