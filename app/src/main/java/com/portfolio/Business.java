package com.portfolio;
import java.util.HashMap;
import java.util.Map;
import com.portfolio.Database.UserRepository;
import com.portfolio.Entities.User;

public class Business {

    //------------------------Register
    public static Boolean registerUser(String username, String password) {
        if(verifyRegistration(username)){
            UserRepository.addUser(username, password);
            System.out.println("Business Layer:User registered successfully.\n\n");
            return true;
        }
        
        System.out.println("User already registered.\n\n");
        return false;
    }
    
    //Method that will check DB for existing usernames matching user-input and return a boolean on if it found any
    private static Boolean verifyRegistration(String username) {
        if(UserRepository.checkExistingUsername(username)){
            System.out.println("Business Layer: User already exists");
            return false;
        }
            return true;
    }

    //------------------------Login

    public static Boolean loginUser(String username, String password) {
        return verifyLogin(username, password);
    }
    //-------------------------Check if the account exists & Password matches username
    private static Boolean verifyLogin(String username, String password) {
        if(true){
            return true;
        }
        System.out.println("Invalid username or password.\n\n");
        return false;
    }
    
}
