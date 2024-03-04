package com.atm;

public class ATMMain {
    public static void main(String[] args) {
        User user = new User("User123", 1234, 1000.00); // Sample user
        ATM atm = new ATM(user);
        atm.startATM(); // Start ATM interface
    }
}

