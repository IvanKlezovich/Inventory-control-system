package com.example.tables;
/**This class was being creating to make sample for set and get items to database.
 * @author Ivan Klezovich
 * @version 1.0*/
public class Units{
    private int idUnit;
    private String nameUnit;
    /**This method for returned id of unit
     * @return id unit
     */
    public int getIdUnit() {
        return idUnit;
    }
    /**This method for set id of units
     * @param idUnit idUnit
     */
    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }

    /**This method for returned name of unit
     * @return nameUnit
     */
    public String getNameUnit() {
        return nameUnit;
    }
    /**This method for set id of units
     * @param nameUnit nameUnit
     */
    public void setNameUnit(String nameUnit) {
        this.nameUnit = nameUnit;
    }
    /**empty class for init.*/
    public Units() {}
    /**This class for set new value in database
     * @param nameUnit ex. kilograms
     */
    public Units(String nameUnit){
        this.nameUnit = nameUnit;
    }
    /**This class for view database units to tableview in form units
     * @param idUnit ex. 1
     * @param nameUnit ex. kilogram
     */
    public Units(int idUnit, String nameUnit) {
        this.idUnit = idUnit;
        this.nameUnit = nameUnit;
    }
}
