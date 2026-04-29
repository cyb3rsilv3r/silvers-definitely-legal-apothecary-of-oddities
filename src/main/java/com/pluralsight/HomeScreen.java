package com.pluralsight;
//With this application you can track all financial transactions for a
//business or for personal use

import java.io.IOException;
import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) throws IOException {
       displayHomeScreen();
    }


//• Home Screen
    public static void displayHomeScreen() throws IOException {
// Add Scanner
        Scanner scanner = new Scanner(System.in);

        boolean running = true; // controls if app keeps running

//     The application should continue to run until the user chooses to exit.
//need a loop here
        while (running) {

            System.out.println("""
  °❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･

      ⁺‧₊˚ ཐི⋆♱⋆ཋྀ ˚₊‧⁺    𝕾𝖎𝖑𝖛𝖊𝖗'𝖘    ⁺‧₊˚ ཐི⋆♱⋆ཋྀ ˚₊‧⁺
            ˖𓍢❀.ೃ  (🇩‌🇪‌🇫‌🇮‌🇳‌🇮‌🇹‌🇪‌🇱‌🇾‌ 🇱‌🇪‌🇬‌🇦‌🇱‌) ˖𓍢❀.ೃ࿔
   ⁺‧₊˚ ཐི⋆♱⋆ཋྀ ˚₊‧⁺  𝔸𝕡𝕠𝕥𝕙𝕖𝕔𝕒𝕣𝕪 𝕠𝕗 𝕆𝕕𝕕𝕚𝕥𝕚𝕖𝕤  ⁺‧₊˚ ཐི⋆♱⋆ཋྀ ˚₊‧⁺

   °❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･
""");
// The home screen should give the user the following options.

//▪ D) Add Deposit
            System.out.println("⋆˙⟡ —{ D } Add Coins to Coffer⋆˙⟡ —");

//▪ P) Make Payment (Debit)
            System.out.println("{ P } Make Payment");

//▪ L) Ledger
            System.out.println("{ L } Ledger");

//▪ X) Exit
            System.out.println("{ X } Exit");


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
                  ledgerScreen.ledgerHome();
                    break;

                case "X":
                 LedgerManager.confirmExit(scanner);
                    System.out.println("Thank you for magically transacting!");
                    running = false; // stops the loop
                    break;

                default:
                    System.out.println("Invalid option");
            }

        }
//remember to close scanner at the end
        scanner.close();

    }//end of main

}//end of public class