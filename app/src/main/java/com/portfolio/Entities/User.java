package com.portfolio.Entities;
 
import java.util.*;

public class User {
    int id;
    String username;
    String password;
    List<Account> accounts;
    Date createdAt;

    public User(int id, String username, String password, List<Account> accounts, Date createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accounts = accounts;
        this.createdAt = createdAt;
    }

    

}
