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
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class UserDAO {
    
        public static boolean registerUser(User user){
            String sql = "INSERT INTO users (user, password) VALUES (?, ?)";
            
            String userN = user.getEmail();
            String password = user.getPassword();
            
            String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
            
            try(Connection conn = ConnectS.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, userN);
                stmt.setString(2, passwordHash);
                
                stmt.executeUpdate();
                
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        
    public static boolean validateLogin(User user) {
            String sql = "SELECT password FROM users WHERE user = ?";

            try (Connection conn = ConnectS.conexao(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setString(1, user.getEmail());
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String passwordHash = rs.getString("password");
                return BCrypt.checkpw(user.getPassword(), passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return false;
    }
        
    public static boolean alterUser(String Nusername, String username, String Npassword){
        String sql = "UPDATE users SET user = ? SET password = ? WHERE user = ?;";
        
        try (Connection conn = ConnectS.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, Nusername);
            stmt.setString(2, Npassword);
            stmt.setString(3, username);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
