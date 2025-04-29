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
import java.util.ArrayList;



/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class ClassDAO {
    public boolean registerClass(Class classN){
        String sql = "INSERT INTO classes (title, text, price) VALUES (?, ?)";
        String titleN = classN.getTitle();
        double priceN = classN.getPrice();
        ArrayList<String> fragText = classN.getText();
        String fullTextN = String.join("", fragText);
        
        try(Connection conn = ConnectS.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, titleN);
                stmt.setString(2, fullTextN);
                stmt.setDouble(3, priceN);
                
                
                stmt.executeUpdate();
                System.out.println("Classe registrada com sucesso.");
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        
    }
    
    public ArrayList<Class> getClassByTitle(String title, ArrayList<Class> FoundClasses, int chunks){
        String sql = "SELECT id, title, text, price FROM classes WHERE title = ?;";
        try (Connection conn = ConnectS.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setString(1, title );
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idS = rs.getInt("id");
                String titleS = rs.getString("title");
                String textS = rs.getString("text");
                double priceS = rs.getDouble("price");
                Class newClass = new Class(titleS, priceS);
                newClass.setText(textS, chunks);
                newClass.setid_class(idS);
                FoundClasses.add(newClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FoundClasses;
    }
    
    public ArrayList<Class> getClassById(int id, ArrayList<Class> FoundClasses, int chunks){
        String sql = "SELECT id, title, text, price FROM classes WHERE title = ?;";
        try (Connection conn = ConnectS.conexao(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idS = rs.getInt("id");
                String titleS = rs.getString("title");
                String textS = rs.getString("text");
                double priceS = rs.getDouble("price");
                 Class newClass = new Class(titleS, priceS);
                newClass.setText(textS, chunks);
                newClass.setid_class(idS);
                FoundClasses.add(newClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FoundClasses;
    }
}
