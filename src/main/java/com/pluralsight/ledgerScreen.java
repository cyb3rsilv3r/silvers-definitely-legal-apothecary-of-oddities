package com.pluralsight;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ledgerScreen {

    //add scanner for user entry
    static Scanner scanner = new Scanner(System.in);

    //create ledger menu
    public static void ledgerHome() {

        boolean inLedger = true;

        while (inLedger) {
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ ⏔⏔⏔ ꧁⎝༺ Grimoire ༻⎠꧂⏔⏔⏔ ꒰ ᧔ෆ᧓ ꒱ ");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱                                    ");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ {A} All Entries ★");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ {D} Deposits ★");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ {P} Payments ★");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ {R} Reports ★");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ {H} Home ★");
            System.out.println(" ꒰ ᧔ෆ᧓ ꒱ ⏔⏔⏔⏔⏔ ꒰ ᧔ෆ᧓ ꒱ ⏔⏔⏔⏔⏔ ꒰ ᧔ෆ᧓ ꒱ ⏔⏔⏔");
            System.out.println(" ⏔ ꒰ ᧔ෆ᧓ ꒱ ⏔Enter selection number:⏔ ꒰ ᧔ෆ᧓ ꒱ ⏔");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    displayAllEntries();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    displayReports();
                    break;
                case "H":
                    inLedger = false;
                    break;
                default:
                    System.out.println("invalid option");
            }
        }

    }//end of ledger home

    //add transactions list to pull info from
    public static ArrayList<String> loadTransactions() {

        // make an ArrayList to hold all transaction lines from the csv file
        ArrayList<String> transactions = new ArrayList<>();

        // surround risky file scanning with try/catch
        try {
            // make a File object connected to transactions.csv
            File file = new File("transactions.csv");

            // make a Scanner that actually reads the file
            Scanner scanner = new Scanner(file);

            // while there are still lines in the file, keep reading
            while (scanner.hasNextLine()) {

                // save the current line from the file
                String line = scanner.nextLine();

                // add that line into the ArrayList
                transactions.add(line);
            }

            // close scanner when done reading
            scanner.close();

        } catch (Exception e) {
            // print error message if file cannot be read
            System.out.println("error reading file");
        }

        // return the list of transaction lines
        return transactions;
    }

    // A) All - Display all entries
    public static void displayAllEntries() {

        // call loadTransactions so we can get all lines from the csv
        ArrayList<String> transactions = loadTransactions();

        System.out.println("✩₊˚.⋆☾⋆⁺₊✧ALL ENTRIES✩₊˚.⋆☾⋆⁺₊✧");

        // loop backwards so newest entries show first
        for (int i = transactions.size() - 1; i >= 0; i--) {

            // print each full transaction line
            System.out.println(transactions.get(i));
        }

        System.out.println("press enter to return ");
        scanner.nextLine();
    }

    // D) Deposits - Display only entries that are deposits
    public static void displayDeposits() {

        // call loadTransactions so we can get all lines from the csv
        ArrayList<String> transactions = loadTransactions();

        System.out.println("✩₊˚.⋆☾⋆⁺₊✧ DEPOSITS ✩₊˚.⋆☾⋆⁺₊✧");

        // loop backwards so newest deposits show first
        for (int i = transactions.size() - 1; i >= 0; i--) {

            // get one full line from the ArrayList
            String line = transactions.get(i);

            // split the line by the pipe symbol
            String[] parts = line.split("\\|");

            // amount is stored in part 4
            String amountStr = parts[4];

            // turn amount from String into double
            double amount = Double.parseDouble(amountStr);

            // deposits are positive numbers
            if (amount > 0) {

                // print full line so the whole transaction shows
                System.out.println(line);

            }//end of if loop
        }//end of for loop

        System.out.println("press enter to return ");
        scanner.nextLine();
    }

    // P) Payments - Display only negative entries
    public static void displayPayments() {

        // call loadTransactions so we can get all lines from the csv
        ArrayList<String> transactions = loadTransactions();

        System.out.println("✩₊˚.⋆☾⋆⁺₊✧PAYMENTS ✩₊˚.⋆☾⋆⁺₊✧");

        // loop backwards so newest payments show first
        for (int i = transactions.size() - 1; i >= 0; i--) {

            // get one full line from the ArrayList
            String line = transactions.get(i);

            // split the line by the pipe symbol
            String[] parts = line.split("\\|");

            // amount is stored in part 4
            String amountStr = parts[4];

            // turn amount from String into double
            double amount = Double.parseDouble(amountStr);

            // payments are negative numbers
            if (amount < 0) {

                // print full line so the whole transaction shows
                System.out.println(line);
            }//end of if
        }//end of for

        System.out.println("press enter to return ");
        scanner.nextLine();
    }//end of display payments

    // R) Reports - A new screen that allows the user to run pre-defined reports or
    // to run a custom search
    public static void displayReports() {

        boolean inReports = true;

        while (inReports) {
            System.out.println("✩₊˚.⋆☾⋆⁺₊✧{Reports}✩₊˚.⋆☾⋆⁺₊✧");
            System.out.println("⋆⭒˚｡⋆1) Month To Date⋆⭒˚｡⋆");
            System.out.println("⋆⭒˚｡⋆2) Previous Month⋆⭒˚｡⋆");
            System.out.println("⋆⭒˚｡⋆3) Year To Date⋆⭒˚｡⋆");
            System.out.println("⋆⭒˚｡⋆4) Previous Year⋆⭒˚｡⋆");
            System.out.println("⋆⭒˚｡⋆5) Search by Vendor⋆⭒˚｡⋆");
            System.out.println("⋆⭒˚｡⋆0) Back⋆⭒˚｡⋆");
            System.out.println("✩₊˚.⋆☾⋆⁺₊✧Enter selection number✩₊˚.⋆☾⋆⁺₊✧");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    monthToDate();
                    break;
                case "2":
                    previousMonth();
                    break;
                case "3":
                    yearToDate();
                    break;
                case "4":
                    previousYear();
                    break;
                case "5":
                    searchByVendor();
                    break;
                case "0":
                    inReports = false;
                    break;
                default:
                    System.out.println("invalid option");
            }//END OF SWITCH
        }

    }//END OF DISPLAY REPORTS

    // 1) Month To Date(month and today)
    public static void monthToDate() {

        ArrayList<String> transactions = loadTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String line = transactions.get(i);
            String[] parts = line.split("\\|");
            LocalDate date = LocalDate.parse(parts[0]);
            LocalDate today = LocalDate.now();

            if (date.getMonth() == today.getMonth()
                    && date.getYear() == today.getYear()) {
                System.out.println(line);
            }
        }//end of for

        System.out.println("press enter to return ");
        scanner.nextLine();

    }//end of month to date

    //▪ 2) Previous Month(month-1)
    public static void previousMonth() {

        ArrayList<String> transactions = loadTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String line = transactions.get(i);
            String[] parts = line.split("\\|");
            LocalDate date = LocalDate.parse(parts[0]);
            LocalDate today = LocalDate.now();

            LocalDate previousMonth = today.minusMonths(1);

            if (date.getMonth() == previousMonth.getMonth()
                    && date.getYear() == previousMonth.getYear()) {
                System.out.println(line);
            }//END OF IF
        }//END OF FOR

        System.out.println("press enter to return ");
        scanner.nextLine();

    } //END OF PREVIOUS MONTH

    //▪ 3) Year To Date
    public static void yearToDate() {

        ArrayList<String> transactions = loadTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String line = transactions.get(i);
            String[] parts = line.split("\\|");
            LocalDate date = LocalDate.parse(parts[0]);
            LocalDate today = LocalDate.now();

            if (date.getYear() == today.getYear()) {
                System.out.println(line);
            }//end of if
        }//END OF FOR

        System.out.println("press enter to return ");
        scanner.nextLine();

    }//end of year to date

    //▪ 4) Previous Year
    public static void previousYear() {

        ArrayList<String> transactions = loadTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String line = transactions.get(i);
            String[] parts = line.split("\\|");
            LocalDate date = LocalDate.parse(parts[0]);
            LocalDate today = LocalDate.now();

            LocalDate previousYear = today.minusYears(1);

            if (date.getYear() == previousYear.getYear()) {
                System.out.println(line);
            }//end of if
        }//end of for

        System.out.println("press enter to return ");
        scanner.nextLine();

    }//end of previous year

    // ▪ 5) Search by Vendor - prompt the user for the vendor name and
    // display all entries for that vendor
    public static void searchByVendor() {

        System.out.println("✩₊˚.⋆enter Merchant name✩₊˚.⋆");
        String vendorSearch = scanner.nextLine();

        ArrayList<String> transactions = loadTransactions();

        for (int i = transactions.size() - 1; i >= 0; i--) {
            String line = transactions.get(i);
            String[] parts = line.split("\\|");

            String vendor = parts[3];

            if (vendor.toLowerCase().contains(vendorSearch.toLowerCase())) {
                System.out.println(line);
            }//end of if
        }//end of for

        System.out.println("press enter to return ");
        scanner.nextLine();

    }//end of search by vendor

}//END OF LEDGER SCREEN CLASS