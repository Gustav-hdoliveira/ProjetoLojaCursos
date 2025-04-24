/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC2.controller;

import biblioMVC2.model.Usuario;
import biblioMVC2.dao.UsuarioDAO;

/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class UsuarioController {
    
    public boolean registrarUsuario(String username, String senha){
        Usuario usuario = new Usuario(username, senha);
        return UsuarioDAO.registarUsuario(usuario);
    }
    
    public boolean validarLogin(String username, char[] charSenha){
        String senha = new String(charSenha).trim();
        
        Usuario usuario = new Usuario(username, senha);
        return UsuarioDAO.validarLogin(usuario);
    }
    
    public boolean alterarUsuario(String NewUsername, String OldUsername, char[] charSenha){
        
        String senha = new String(charSenha).trim();
        if(NewUsername.isEmpty()||senha.isEmpty()){
            return false;
        }
        return UsuarioDAO.alterarUsuario(NewUsername, OldUsername, senha);
    }
}
