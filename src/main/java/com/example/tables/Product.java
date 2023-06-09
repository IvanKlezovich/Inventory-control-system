package com.example.tables;
/**This class was being creating to make sample for set and get items to database.
 * @author Ivan Klezovich
 * @version 1.0*/
public class Product{
    private int idProduct;
    private String nameProduct;
    private int idUnits;
    private int countWare;
    private String description;
    /**This method for returned id of product.
     * @return idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }
    /**This method for set id of product.
     * @param idProduct idProduct
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    /**This method for returned name of product.
     * @return nameProduct
     */
    public String getNameProduct() {
        return nameProduct;
    }
    /**This method for set name of product.
     * @param nameProduct nameProduct
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    /**This method for returned id of units.
     * @return idUnits
     */
    public int getIdUnits() {
        return idUnits;
    }
    /**This method for set id of units.
     * @param idUnits idUnits
     */
    public void setIdUnits(int idUnits) {
        this.idUnits = idUnits;
    }
    /**This method for returned count product on ware.
     * @return countWare
     */
    public int getCountWare() {
        return countWare;
    }
    /**This method for set count product on ware.
     * @param countWare countWare
     */
    public void setCountWare(int countWare) {
        this.countWare = countWare;
    }
    /**This method for returned discription of product.
     * @return description */
    public String getDescription() {
        return description;
    }
    /**This method for set id of product.
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** empty class for init.*/
    public Product() {}
    /**This class for set new value in database
     * @param nameProduct nameProduct ex. banana, phone
     * @param idUnits idUnits ex. 1, 9, 10
     * @param countWare countWare ex. 15, 89
     * @param description description */
    public Product(String nameProduct, int idUnits, int countWare, String description) {
        this.nameProduct = nameProduct;
        this.idUnits = idUnits;
        this.countWare = countWare;
        this.description = description;
    }
    /**This class for view database units to tableview in form product.
     * @param idProduct idProduct ex. 1,2,3
     * @param nameProduct nameProduct ex. banana, phone
     * @param idUnits idUnits ex. 1, 9, 10
     * @param countWare countWare ex. 15, 89
     * @param description description */
    public Product(int idProduct, String nameProduct, int idUnits, int countWare, String description) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.idUnits = idUnits;
        this.countWare = countWare;
        this.description = description;
    }
}
