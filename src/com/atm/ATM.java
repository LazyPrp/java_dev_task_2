package com.atm;

import java.util.Scanner;

public class ATM {
    private User currentUser;

    public ATM(User currentUser) {
        this.currentUser = currentUser;
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************************************************");
        System.out.println("\t  Welcome to the ATM !!!!!! :)");
        
        // User authentication
        while (true) {
            System.out.print("\tEnter user ID: ");
            String userID = scanner.next();
            System.out.print("\tEnter PIN: ");
            int pin = scanner.nextInt();
            
            if (userID.equals(currentUser.getUserID()) && pin == currentUser.getUserPIN()) {
                System.out.println("   Authentication successfull. :)");
                break;
            } else {
                System.out.println("   Incorrect ID or PIN. :(  Please try again.  ");
            }
        }
        
        // Main menu
        boolean running = true;
        while (running) {
            System.out.println("\n\t[1]. Check Balance\n\t[2]. Deposit Money\n\t[3]. Withdraw Money\n\t[4]. Exit");
            System.out.print("\tChoose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Checking balance
                    System.out.println("\tCurrent balance: Rs" + currentUser.getAccountBalance());
                    break;
                case 2:
                    // Depositing money
                    System.out.print("\tEnter amount to deposit: Rs");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        currentUser.setAccountBalance(currentUser.getAccountBalance() + depositAmount);
                        System.out.println("\tSuccessfully deposited Rs" + depositAmount);
                    } else {
                        System.out.println("\tInvalid amount.");
                    }
                    break;
                case 3:
                    // Withdrawing money
                    System.out.print("\tEnter amount to withdraw: Rs");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= currentUser.getAccountBalance()) {
                        currentUser.setAccountBalance(currentUser.getAccountBalance() - withdrawAmount);
                        System.out.println("\tSuccessfully withdrew Rs" + withdrawAmount);
                    } else {
                        System.out.println("\tInvalid amount or insufficient funds.");
                    }
                    break;
                case 4:
                    // Exit
                    System.out.println("\tThank you for using the ATM. Goodbye!!!!!");
                    System.out.println("*************************************************************");

                    running = false;
                    break;
                default:
                    System.out.println("\tInvalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}