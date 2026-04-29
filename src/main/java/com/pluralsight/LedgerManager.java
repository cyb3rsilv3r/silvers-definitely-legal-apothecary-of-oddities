package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LedgerManager {

    public static void addDeposit(Scanner scanner) throws IOException {

        // 1. collect information

        // date
        System.out.println("Enter Date");
        String date = scanner.nextLine();

        // time
        System.out.println("Enter Time");
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

        // 3. add if for confirmation
        if (confirm.equalsIgnoreCase("Y")) {

            // create transaction
            Transaction t = new Transaction(date, time, description, vendor, amount);

            // print confirmation
            System.out.println("Deposit confirmed!");

            // write transaction to csv (we add this next)
            writeTransaction(t);
        }

        //  if no
        else {
            System.out.println("Transaction cancelled.");
        }
        // after confirmed OR canceled
        System.out.println("\nPress Enter to return to home...");
        scanner.nextLine();
    } //end of addDeposit method

    // Create method for making payments
    public static void makePayment(Scanner scanner) throws IOException {
        //collect info on payments (same format as deposit but negative)

        // 1. collect information again

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

            // write transaction to csv
            writeTransaction(t);

        }

        // 4. if no
        else {
            System.out.println("Payment cancelled. Returning to menu.");
        }
        // after confirmed OR canceled
        System.out.println("\nPress Enter to return to home...");
        scanner.nextLine();
    }


    public static void writeTransaction(Transaction t) throws IOException {
        //add file writer

        //create method inside try/catch to write to csv file
        FileWriter writer = new FileWriter("transactions.csv", true);

        //add variable to store line
        String line = t.getDate() + "|" +
                t.getTime() + "|" +
                t.getDescription() + "|" +
                t.getVendor() + "|" +
                t.getAmount() + "\n";
        // have writer put the line together and close after
        writer.write(line);
   //remember to close writer
        writer.close();

    }//END OF WRITE TRANSACTION

    // Make method for exit
    public static void confirmExit(Scanner scanner) {
        // ask for confirmation of exit
        System.out.println("Are you sure you want to exit? Y/N");
        String answer = scanner.nextLine();

        //create boolean if statement to assist exit
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Now exiting store..");
        } else
            System.out.println("\nPress Enter to return to home...");
    }
}//end of class
