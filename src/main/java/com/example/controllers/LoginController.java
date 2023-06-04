package com.example.controllers;

import com.example.connection.Const;
import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**This class for login user
 * @author Ivan Klezovich
 * @version 1.3
 */

public class LoginController{
    CurseProject curseProject = new CurseProject();
    @FXML
    private TextField inputLogin;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Button loginButton;
    @FXML
    private Button regestrationButton;

    /**Method for login user and if data of field wrong open registration form*/

    @FXML
    void initialize(){
        loginButton.setOnAction(actionEvent -> {
            loginButton.getScene().getWindow().hide();
            String logg = inputLogin.getText().trim();
            String pass = inputPassword.getText().trim();
            if(!logg.equals("") && !pass.equals(""))
                singInNewUser(logg, pass);
            else
                System.out.println("Empty strings");
        });
        regestrationButton.setOnAction(actionEvent -> {
            regestrationButton.getScene().getWindow().hide();
            curseProject.window("registration.fxml", 360, 520, "registration");
        });
    }

    /**Method for protection against incorrect data entry
     * @param logg login of user
     * @param pass password of user
     */

    private void singInNewUser(String logg, String pass) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String message = "SELECT * FROM " + Const.USER_TABLE + ";";
        try (ResultSet rs = dbHandler.getDbconnection().createStatement().executeQuery(message)){
            while (rs.next()) {
                String login = rs.getString(Const.USER_NAME);
                String password = rs.getString(Const.USER_PASSWORD);
                boolean auth = rs.getBoolean(Const.USER_AUTHORIZATION);
                if(auth && login.equals(logg) && password.equals(pass)){
                    this.curseProject.window("product.fxml", 720, 635, "product");
                    break;
                }
            }
            curseProject.window("error.fxml", 120, 360, "error");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}