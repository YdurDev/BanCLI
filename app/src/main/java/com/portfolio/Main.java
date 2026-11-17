package com.portfolio;
import java.util.*;

import com.portfolio.Database.DatabaseInitializer;

public class Main {
    public final static Scanner scn = new Scanner(System.in);
    

    public static void main(String[] args) {
        // Initialize the database and create the user&accounts tables if they don't exist
        DatabaseInitializer dbInitializer = new DatabaseInitializer();
        dbInitializer.createUserTable();
        dbInitializer.createAccountTable();
        dbInitializer.createAdminUser();

        // Start the API and handle user login
        API api = new API();
        api.login();
    }
}
