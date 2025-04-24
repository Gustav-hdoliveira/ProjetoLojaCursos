/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC2.dao;

import biblioMVC2.database.Conexao;
import biblioMVC2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class UsuarioDAO {
    
        public static boolean registarUsuario(Usuario usuario){
            String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
            
            String user = usuario.getEmail();
            String senha = usuario.getSenha();
            
            String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());
            
            try(Connection conn = Conexao.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, user);
                stmt.setString(2, senhaHash);
                
                stmt.executeUpdate();
                
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        
    public static boolean validarLogin(Usuario usuario) {
            String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

            try (Connection conn = Conexao.conexao(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setString(1, usuario.getEmail());
                ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaHash = rs.getString("senha");
                return BCrypt.checkpw(usuario.getSenha(), senhaHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return false;
    }
        
    public static boolean alterarUsuario(String Nusername, String username, String Npassword){
        String sql = "UPDATE usuarios SET usuario = ? SET senha = ? WHERE usuario = ?;";
        
        try (Connection conn = Conexao.conexao(); PreparedStatement stmt = conn.prepareStatement(sql)){
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
