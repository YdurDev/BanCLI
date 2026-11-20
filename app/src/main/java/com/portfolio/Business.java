package com.portfolio;
import java.util.HashMap;
import java.util.Map;
import com.portfolio.Database.UserRepository;
import com.portfolio.Entities.User;

public class Business {

    //------------------------Register
        //-------------Call verifyRegistration in same-layer to verify registration
    public static Boolean registerUser(String username, String password) {
        //------If it resolves to true go through with adding user
        if(verifyRegistration(username)){
            UserRepository.addUser(username, password);
            System.out.println("Business Layer:User registered successfully.\n\n");
            return true;
        }
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
        //-----------Call verifyLogin in same-layer to verify login
        return verifyLogin(username, password);
    }

    //-------------------------Check if the account exists & Password matches username
    private static Boolean verifyLogin(String username, String password) {
        if(UserRepository.checkCredentials(username, password)){
            return true;
        }
        System.out.println("Business Layer:Invalid username or password.\n\n");
        return false;
    }
    
}
