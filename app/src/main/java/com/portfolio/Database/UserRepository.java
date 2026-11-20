package com.portfolio.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.portfolio.Business;
import com.portfolio.Entities.User;

public class UserRepository {

//------------------------Check for a user by username, return TRUE if name exists, FALSE if no user of that name exists
    public static boolean checkExistingUsername(String username) {
        //Set-up the SQL query to be executed
        String sql = "SELECT username " +  
                    "FROM USERS " +  
                    "WHERE username = (?)";
        //Create a connection to the database and prepare the SQL statement
        try(Connection conn = ConnectionFactory.getAutoCommitConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);){
                //Now that we have the connection within the try-with-resources block, we can set the parameters for
                //  the prepared statement and execute it to CREATE a new Person Object from our Database and then RETURN it. 
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //-------------------------Add a User
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-------------------------


}
