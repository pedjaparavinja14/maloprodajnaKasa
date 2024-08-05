/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Djapac
 */
public class DatabaseConnection {
    private List<Connection> connectionPool;
    private static DatabaseConnection instance;

    public DatabaseConnection() throws SQLException {
        connectionPool = new ArrayList<>();
        
        for(int i = 0; i < 100; i++){
            try {
                String url = "jdbc:mysql://localhost:3307/kasa";
                String user = "root";
                String password = "";
                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("Konekcija sa bazom podataka uspesno uspostavljena!");
                

                
                connection.setAutoCommit(false);
                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }
    }
     public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }

    public synchronized Connection pop() throws Exception {
        if (connectionPool.isEmpty()) {
            throw new Exception("Nema slobodne konekcije");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
    
    
    
    
}
