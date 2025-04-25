/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;



/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class ClassDAO {
    public static boolean RegistrarCurso(Class classN){
        String sql = "INSERT INTO classes (title, text, price) VALUES (?, ?)";
        
        String titleN = classN.getTitle();
        double priceN = classN.getPrice();
        int i = 0;
        String Ntext;
        while(classN.text.length() > i){
            
        }
    }
}
