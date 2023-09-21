/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class ConnectionFactory {
    
    private final String dbHost = "localhost";
    private final String dbPort = "3306";
    private final String dbName = "BDVENDAS";
    private final String dbUser = "root";
    private final String dbPass = "";
    
    public Connection getConnection() {
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName, dbUser, dbPass);
            
        } catch(SQLException erro) {
            
            throw new RuntimeException(erro);
            
        }
        
    }
    
}