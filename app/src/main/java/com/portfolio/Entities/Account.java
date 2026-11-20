package com.portfolio.Entities;

public class Account {
    int id;
    int userId;
    double balance;
    String accountType;

    public Account(int id, int userId, double balance, String accountType) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.accountType = accountType;
    }
    
}
