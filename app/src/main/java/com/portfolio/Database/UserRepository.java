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

    //-------------------------Check credentials
    public static boolean checkCredentials(String username, String password){
        //-------Setup query-string
        String sql = "SELECT username, password FROM users WHERE username = (?)";
        //Setup Connection and prepared statement  in try-with-resources since both could throw SQLException
        try(Connection conn = ConnectionFactory.getAutoCommitConnection();
            //-------Plug SQL into prepared statement
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                //-----------Set parameters  for the prepared statement as per usual
            stmt.setString(1, username);
            //-------Grab the executed query inside a ResultSet and extract the username and password from it
            ResultSet rs = stmt.executeQuery();
            String foundUsername = rs.getString(1);
            String foundPassword = rs.getString(2);
            //--------Use the extracted data to do the logic-check
            //---------We already know the username exists since thats what we queried the DB for, [Confirm this later,probably not 100% true]
            if(!password.equals(foundPassword)){
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
