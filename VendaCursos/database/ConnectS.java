/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.VendaCursos.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author GUSTAVOHENRIQUEDEOLI
 */
public class ConnectS {
    private static final Dotenv dotenv = Dotenv.load();
    
    private static Connection connection;
    
    private static final String URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    public static Connection conexao() {
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
                createTableUsers();
                createTableClasses();
                System.out.println("Conected to the databank");
            }
        } catch (SQLException error){
            System.out.println("Error: " + error.getMessage());
            throw new RuntimeException("Error in the connection with the databank: ", error);
        }
        
        return connection;
    }
    
    private static void createTableUsers(){
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "user VARCHAR(255) NOT NULL UNIQUE, "
                + "password VARCHAR(255) NOT NULL)";
        try (Statement stmt = connection.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error when creating table users: ", e);
        }
    }
    
    private static void createTableClasses(){
        String sql = "CREATE TABLE IF NOT EXISTS classes ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "title VARCHAR(255) NOT NULL UNIQUE, "
                + "text TEXT NOT NULL, "
                + "price DOUBLE NOT NULL)";
        try (Statement stmt = connection.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("Error when crating table class", e);
        }
    }
}
