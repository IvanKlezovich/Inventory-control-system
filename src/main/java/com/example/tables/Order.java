package com.example.tables;
/**This class was being creating to make sample for set and get items to database.
 * @author Ivan Klezovich
 * @version 1.0*/
public class Order {
    private int idOrder;
    private int idProvider;
    private int idProduct;
    private int prise;
    private int amountOfOrder;
    private String deliveryTime;
    /**This method returns id of Product.
     * @return idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }
    /**This method set id of product
     * @param idProduct idProduct
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    /**This method return number of order.
     * @return idOrder
     */
    public int getIdOrder() {
        return idOrder;
    }
    /**This method set id of order.
     * @param idOrder idOrder
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    /**This method for ger id of provider.
     * @return idProvider
     */
    public int getIdProvider() {
        return idProvider;
    }
    /**This method for set id of provider.
     * @param idProvider idProvider
     */
    public void setIdProvider(int idProvider) {this.idProvider = idProvider;}
    /**This method for get prise
     * @return prise
     */
    public int getPrise() {
        return prise;
    }
    /**This method for set prise
     * @param prise prise
     */
    public void setPrise(int prise) {
        this.prise = prise;
    }
    /**This method for get amount of order
     * @return amount of order
     */
    public int getAmountOfOrder() {
        return amountOfOrder;
    }
    /**This method for set amount of order.
     * @param amountOfOrder amount of order
     */
    public void setAmountOfOrder(int amountOfOrder) {
        this.amountOfOrder = amountOfOrder;
    }
    /**This method for get delivery time
     * @return deliveryTime
     */
    public String getDeliveryTime() {
        return deliveryTime;
    }
    /**This method sets delivery time
     * @param deliveryTime deliveryTime
     */
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    /**Empty constructor for initialize class Order.*/
    public Order() {}
    /**Constructor with some parameters. This constructor may be used for write information of Orders by database.
     * @param idProvider id of provider
     * @param idProduct id of product
     * @param prise prise
     * @param amountOfOrder amount of order
     * @param deliveryTime delivery time
     */
    public Order(int idProvider, int idProduct, int prise, int amountOfOrder, String deliveryTime) {
        this.idProvider = idProvider;
        this.idProduct = idProduct;
        this.prise = prise;
        this.amountOfOrder = amountOfOrder;
        this.deliveryTime = deliveryTime;
    }
    /**Constructor with some parameters. This constructor may be used for write information by database.
     * @param idOrder id of order
     * @param idProvider id of provider
     * @param idProduct id of product
     * @param prise prise
     * @param amountOfOrder amount of order
     * @param deliveryTime delivery time
     */
    public Order(int idOrder, int idProvider, int idProduct, int prise, int amountOfOrder, String deliveryTime) {
        this.idOrder = idOrder;
        this.idProvider = idProvider;
        this.idProduct = idProduct;
        this.prise = prise;
        this.amountOfOrder = amountOfOrder;
        this.deliveryTime = deliveryTime;
    }
}