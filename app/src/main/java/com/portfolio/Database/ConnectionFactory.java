package com.portfolio.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    public static final String URL = System.getenv("BANCLI_DB_PATH");

    //Here we can create a method to get -> configure(with auto-commit enabled) -> return a connection 
    public static Connection getAutoCommitConnection() {
        // Use a regular try-catch block to handle the SQLException while creating the connection
        try {
            Connection connection = DriverManager.getConnection(URL);
            // Set auto-commit to true for this connection
            connection.setAutoCommit(true);
            return connection;
        } catch(SQLException e) {
            System.err.println("Error while creating auto-commit connection: " + e.getMessage());
            throw new RuntimeException("Error while creating auto-commit connection", e);
        }
    }
}
