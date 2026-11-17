package com.portfolio.Database;

import java.sql.*;

public class DatabaseInitializer {

    public void createUserTable(){
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "username VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (Connection conn = ConnectionFactory.getAutoCommitConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("User table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating user table: " + e.getMessage());
        }
    }
    
}
