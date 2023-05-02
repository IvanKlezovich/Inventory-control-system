package com.example.controllers;

import com.example.connection.DatabaseHandler;
import com.example.main.CurseProject;;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.tables.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController{
    CurseProject cp = new CurseProject();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputLogin;

    @FXML
    private PasswordField inputPassword;
    @FXML
    private Button loginButton;
    @FXML
    private Button regestrationButton;

    @FXML
    void initialize() throws IOException {
        loginButton.setOnAction(actionEvent -> {
            loginButton.getScene().getWindow().hide();
            String logg = inputLogin.getText().trim();
            String pass = inputPassword.getText().trim();

            if(!logg.equals("") && !pass.equals(""))
                singInNewUser(logg, pass);
            else
                System.out.println("Empty strings");
            try {
                cp.escLogin();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        regestrationButton.setOnAction(actionEvent -> {
            regestrationButton.getScene().getWindow().hide();
            try{
                cp.registration();
            }catch (IOException e){
                System.out.println("Click");
            }
        });
    }

    private void singInNewUser(String logg, String pass) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setName(logg);
        user.setPassword(pass);
        ResultSet resultSet = dbHandler.getUser(user);
        int counter = 0;

        try {
            while (resultSet.next()) {
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(counter != 0){
            try {
                cp.product();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            try {
                cp.error();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}