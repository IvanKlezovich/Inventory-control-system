package com.example.tables;
/**This class was being creating to make sample for set and get items to database.
 * @author Ivan Klezovich
 * @version 1.3*/
public class User {
    private String name;
    private String password;
    /**This method for returned name of User
     * @return name*/
    public String getName() {
        return name;
    }
    /**This method for set name of product
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**this method for returned password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**This method for set name of product
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /** empty class for user*/
    public User() {
    }
    /**
     * This class for view database units for form Login
     * @param name ex.klezovich
     * @param password ex. 23122003
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}