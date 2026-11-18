package com.portfolio.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRepository {

    public static void addUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        //Create a connection to the database and prepare the SQL statement
        try(Connection conn = ConnectionFactory.getAutoCommitConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
                //Now that we have the connection within the try-with-resources block, we can set the parameters for
                //  the prepared statement and execute it to insert the new user into the database
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
