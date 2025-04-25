/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class User {
    private int id;
    private String email;
    private String password;

    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public void setId(int i){
        id = i;
    }
    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
