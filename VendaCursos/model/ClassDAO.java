/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.model;

import com.example.VendaCursos.database.ConnectS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class ClassDAO {
    public static boolean registerClass(Class classN){
        String sql = "INSERT INTO classes (title, text, price) VALUES (?, ?)";
        String titleN = classN.getTitle();
        double priceN = classN.getPrice();
        String[] fullText = classN.getText();
        String fullTextN = String.join("", fullText);
        
        try(Connection conn = ConnectS.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, titleN);
                stmt.setString(2, fullTextN);
                stmt.setDouble(3, priceN);
                
                
                stmt.executeUpdate();
                
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
    }
    
    public static boolean getClassByTitle(String title, Class[] FoundClasses, double chunks){
        String sql = "SELECT id, title, text, price FROM classes WHERE title = ?;";
        try (Connection conn = ConnectS.conexao(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setString(1, title );
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Class newClass = new Class();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return false;
    }
    
    public static boolean getClassById(){
        String sql = "SELECT id, title, text, price FROM classes WHERE id = ?;";
        
    }
}
