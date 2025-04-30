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
    public boolean registerClass(Course CourseN){
        String sql = "INSERT INTO classes (chunks, title, text, price) VALUES (?, ?, ?, ?)";
        int chunksN = CourseN.getChunks();
        String titleN = CourseN.getTitle();
        double priceN = CourseN.getPrice();
        ArrayList<String> fragText = CourseN.getText();
        String fullTextN = String.join("", fragText);
        
        try(Connection conn = ConnectS.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, chunksN);
                stmt.setString(2, titleN);
                stmt.setString(3, fullTextN);
                stmt.setDouble(4, priceN);
                
                
                stmt.executeUpdate();
                System.out.println("Classe registrada com sucesso.");
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        
    }
    
    public ArrayList<Course> getClasses(){
        String sql = "SELECT * FROM classes; ";
        ArrayList<Course> FoundClasses = new ArrayList<>();
        try(Connection conn = ConnectS.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int idS = rs.getInt("id");
                String titleS = rs.getString("title");
                String textS = rs.getString("text");
                double priceS = rs.getDouble("price");
                int chunksN = rs.getInt("chunks");
                Course newCourse = new Course(titleS, priceS);
                newCourse.setTextArray(textS, chunksN);
                newCourse.setid_class(idS);
                FoundClasses.add(newCourse);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return FoundClasses;
    }
    
    public ArrayList<Course> getClassByTitle(String title){
        String sql = "SELECT * FROM classes WHERE title = ?;";
        ArrayList<Course> FoundClasses = new ArrayList<>();
        try (Connection conn = ConnectS.conexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setString(1, title );
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idS = rs.getInt("id");
                String titleS = rs.getString("title");
                String textS = rs.getString("text");
                double priceS = rs.getDouble("price");
                int chunksN = rs.getInt("chunks");
                Course newCourse = new Course(titleS, priceS);
                newCourse.setTextArray(textS, chunksN);
                newCourse.setid_class(idS);
                FoundClasses.add(newCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FoundClasses;
    }
    
    public ArrayList<Course> getClassById(int id){
        String sql = "SELECT * FROM classes WHERE id = ?;";
        ArrayList<Course> FoundClasses = new ArrayList<>();
        try (Connection conn = ConnectS.conexao(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idS = rs.getInt("id");
                String titleS = rs.getString("title");
                String textS = rs.getString("text");
                double priceS = rs.getDouble("price");
                int chunksN = rs.getInt("chunks");
                 Course newCourse = new Course(titleS, priceS);
                newCourse.setTextArray(textS, chunksN);
                newCourse.setid_class(idS);
                FoundClasses.add(newCourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FoundClasses;
    }
    
}
