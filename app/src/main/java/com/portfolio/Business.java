package com.portfolio;
import java.util.HashMap;
import java.util.Map;
public class Business {
    public static Map<String, String> registeredUsers = new HashMap<>();
    //------------------------Default Admin User made using "static initializer block"
    static {
        registeredUsers.put("admin", "admin");
    }
    //------------------------Register
    public static Boolean registerUser(String username, String password) {
        return verifyRegistration(username, password);
    }
    
    private static Boolean verifyRegistration(String username, String password) {
        if(registeredUsers.containsKey(username)){
            System.out.println("User already registered.\n\n");
            return false;
        }
        registeredUsers.put(username, password);
        System.out.println("User registered successfully.\n\n");
        return true;
    }

    //------------------------Login

    public static Boolean loginUser(String username, String password) {
        return verifyLogin(username, password);
    }

    private static Boolean verifyLogin(String username, String password) {
        if(registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)){
            return true;
        }
        System.out.println("Invalid username or password.\n\n");
        return false;
    }
    
}
