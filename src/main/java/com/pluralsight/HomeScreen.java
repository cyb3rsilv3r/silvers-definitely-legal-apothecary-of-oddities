package com.pluralsight;
//With this application you can track all financial transactions for a
//business or for personal use

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {

//tasks:
//• Home Screen
// Add Scanner
        Scanner scanner = new Scanner(System.in);

        boolean running = true; // controls if app keeps running

//     The application should continue to run until the user chooses to exit.
//need a loop here
        while (running) {

// The home screen should give the user the following options.

//▪ D) Add Deposit
            System.out.println("{ D } Add Deposit");

//▪ P) Make Payment (Debit)
            System.out.println("{ P } Make Payment");

//▪ L) Ledger
            System.out.println("{ L } Ledger");

//▪ X) Exit
            System.out.println("{ X } Exit ");

// get user input
            String choice = scanner.nextLine();

// decide what to do
            switch (choice.toUpperCase()) {

                case "D":
                    LedgerManager.addDeposit(scanner);
                 //   System.out.println("Add Deposit selected");
                    //insert deposit screen art here
                    break;

                case "P":
                    LedgerManager.makePayment(scanner);
//                    System.out.println("Make Payment selected");

                    break;

                case "L":
                    System.out.println("Ledger selected");
                    break;

                case "X":
                    System.out.println("Exiting application");
                    System.out.println("Thank you for magically transacting!");
                    running = false; // stops the loop
                    break;

                default:
                    System.out.println("Invalid option");
            }

        }

        scanner.close();

    }//end of main

}//end of public class