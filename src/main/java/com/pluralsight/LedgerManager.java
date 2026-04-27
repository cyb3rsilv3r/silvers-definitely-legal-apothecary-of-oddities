package com.pluralsight;

import java.util.Scanner;

public class LedgerManager {

    public static void addDeposit(Scanner scanner) {

        // 1. collect information

        // date
        System.out.println("Enter date [yyyy-mm-dd] :");
        String date = scanner.nextLine();

        // time
        System.out.println("Enter time [hh:mm:ss] :");
        String time = scanner.nextLine();

        // ask description
        System.out.println("Enter description:");
        String description = scanner.nextLine();

        // ask vendor
        System.out.println("Enter Vendor:");
        String vendor = scanner.nextLine();

        // ask amount
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();

        //remember to add buffer after double
        scanner.nextLine();

        // 2. show confirmation message
        System.out.println("\nNew transaction:");
        System.out.println(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);

        // ask if correct
        System.out.println("does this look correct? Y/N");
        String confirm = scanner.nextLine();

        // 3. if yes
        if (confirm.equalsIgnoreCase("Y")) {

            // create transaction
            Transaction t = new Transaction(date, time, description, vendor, amount);

            // print confirmation
            System.out.println("Deposit confirmed!");

            // write transaction to csv (we add this next)

        }

        // 4. if no
        else {
            System.out.println("Transaction cancelled. Returning to menu.");
        }

    } //end of addDeposit method

    // Create method for making payments
    public static void makePayment(Scanner scanner) {
        //collect info on payments (same format as deposit but negative)

        // 1. collect information

        // date
        System.out.println("Enter date [yyyy-mm-dd] :");
        String date = scanner.nextLine();

        // time
        System.out.println("Enter time [hh:mm:ss] :");
        String time = scanner.nextLine();

        // ask description
        System.out.println("Enter description:");
        String description = scanner.nextLine();

        // ask vendor
        System.out.println("Enter Vendor:");
        String vendor = scanner.nextLine();

        // ask amount
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        amount = amount * -1;

        //remember to add buffer after double
        scanner.nextLine();

        // 2. show confirmation message
        System.out.println("\nNew Payment:");
        System.out.println(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);

        // ask if correct
        System.out.println("does this look correct? Y/N");
        String confirm = scanner.nextLine();

        // 3. if yes
        if (confirm.equalsIgnoreCase("Y")) {

            // create transaction
            Transaction t = new Transaction(date, time, description, vendor, amount);

            // print confirmation
            System.out.println("Payment confirmed!");

            // write transaction to csv (we add this next)

        }

        // 4. if no
        else {
            System.out.println("Payment cancelled. Returning to menu.");
        }


    }
}//end of class
