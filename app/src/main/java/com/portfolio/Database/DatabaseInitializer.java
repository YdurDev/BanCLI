package com.portfolio.Database;

import java.sql.*;

public class DatabaseInitializer {

    public void createUserTable(){
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "username VARCHAR(255) NOT NULL UNIQUE, " +
        "password VARCHAR(255) NOT NULL, " +
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

    public void createAccountTable() {
        String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER NOT NULL, " +
                "account_name VARCHAR(255) NOT NULL, " +
                "balance DECIMAL(10, 2) DEFAULT 0.00, " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "FOREIGN KEY (user_id) REFERENCES users(id)" +
                ");";

        try (Connection conn = ConnectionFactory.getAutoCommitConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Account table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating account table: " + e.getMessage());
        }
    }

    public void createAdminUser() {
    String sql = "INSERT OR IGNORE INTO users (username, password) VALUES ('admin', 'admin')";

    try (Connection conn = ConnectionFactory.getAutoCommitConnection();
         Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(sql);
        System.out.println("Admin user ready.");
    } catch (SQLException e) {
        throw new RuntimeException("Error creating admin user", e);
    }
}
    
}
