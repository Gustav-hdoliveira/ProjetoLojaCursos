/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.controller;

import com.example.VendaCursos.model.User;
import com.example.VendaCursos.model.UserDAO;



/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class UserController {
    
    public boolean registerUser(String username, String password){
        User User = new User(username, password);
        return UserDAO.registerUser(User);
    }
    
    public boolean validateLogin(String username, String password){
        User User = new User(username, password);
        return UserDAO.validateLogin(User);
    }
    
    public boolean alterUser(String NewUsername, String OldUsername, char[] charPassword){
        
        String password = new String(charPassword).trim();
        if(NewUsername.isEmpty()||password.isEmpty()){
            return false;
        }
        return UserDAO.alterUser(NewUsername, OldUsername, password);
    }
}
