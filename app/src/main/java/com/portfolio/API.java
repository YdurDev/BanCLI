package com.portfolio;

import java.util.*;

public class API {
    private final Scanner scn = new Scanner(System.in);

    public API(){}

    public void login(){
        while (true) {

            //------------------------Main Menu
            System.out.println("o~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~o\n" + "  Welcome to BanCLI, Choose your action:");
            System.out.println("  [L] - Login [R] - Register [Q] - Quit");
            System.out.println("o~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~o\n");
            System.out.print(">>");
            String userIn = scn.nextLine();
            System.out.println(userIn);

            //------------------------Quit
            if(userIn.equalsIgnoreCase("q")||userIn.equalsIgnoreCase("quit")||userIn.equalsIgnoreCase("exit")){
                System.out.println("Exiting...\n\n");
                break;
            }
            //------------------------Login
            else if(userIn.equalsIgnoreCase("l")||userIn.equalsIgnoreCase("login")){
                System.out.print("Username: ");
                String username = scn.nextLine();
                System.out.print("Password: ");
                String password = scn.nextLine();

                if(Business.loginUser(username, password)){
                    System.out.println("Login successful.\n");
                }
                //------------------------Bank Operations
                while(true){
                    System.out.println("o~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~o\n" + "           Choose your action:");
                    System.out.println("\t[D]-Deposit \t[W]-Withdraw\n\t[B]-Balance\t[T]-Transfer\n\t\t[Q]-Quit");
                    System.out.println("o~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~o\n");
                    String bankInput = scn.nextLine();
                    //------------------------Deposit
                    if(bankInput.equalsIgnoreCase("d")||bankInput.equalsIgnoreCase("deposit")){
                        System.out.print("Amount to deposit: ");
                        double amount = Double.parseDouble(scn.nextLine());
                        //Business.deposit(username, amount);
                    }

                    if(bankInput.equalsIgnoreCase("q")||bankInput.equalsIgnoreCase("quit")||bankInput.equalsIgnoreCase("exit")){
                        System.out.println("Exiting...\n\n");
                        break;
                    }
                }
            }

            //------------------------Register
            else if(userIn.equalsIgnoreCase("r")||userIn.equalsIgnoreCase("register")){
                System.out.print("Username: ");
                String username = scn.nextLine();
                System.out.print("Password: ");
                String password = scn.nextLine();

                Business.registerUser(username, password);
                
            }
            //------------------------Test
            else if(userIn.equalsIgnoreCase("tst")){
                System.out.println(Business.registeredUsers);
                
            }
            //------------------------Invalid Input
            else if(userIn.equalsIgnoreCase("tst")){
                System.out.println(Business.registeredUsers);
            }
            else{
                System.out.println("\n" + "Invalid input");
            }
        }
    }
    
}