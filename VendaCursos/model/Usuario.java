/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class Usuario {
    private int id;
    private String email;
    private String senha;

    
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
