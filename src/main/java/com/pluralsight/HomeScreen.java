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

            System.out.println("°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･");
            System.out.println("                 welcome to ");
            System.out.println("          ཐི⋆♱  𝓢𝓲𝓵𝓿𝓮𝓻'𝓼  ♱⋆ཋྀ ˚");
            System.out.println(" .  ཐི⋆♱⋆ཋྀ    (definitely legal)  ི⋆♱⋆ཋྀ  ");
            System.out.println("           𝔸𝕡𝕠𝕥𝕙𝕖𝕔𝕒𝕣𝕪 𝕠𝕗 𝕆𝕕𝕕𝕚𝕥𝕚𝕖𝕤   ");

            System.out.println("°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･°❀⋆.ೃ࿔*:･");
            System.out.println("── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──");
            System.out.println("⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊⊹ Main Menu ⊹₊˚‧︵‿₊୨ᰔ୧₊‿︵‧˚₊⊹");
// The home screen should give the user the following options.

//D) Add Deposit - Add coins to coffer
//P) Make Payment (Debit)- Empty coffer
            //L) Ledger- Grimoire
            System.out.println("꒰ა ☆ ໒꒱{ D } Add Coins to Coffer ☾ ˚.⋆   ✩˚.⋆   ✩");
            System.out.println("꒰ა ☆ ໒꒱{ P } Empty Coffers ₊˚.⋆✩₊˚.⋆⋆ ˚｡⋆  ˚.⋆   ✩ ");
            System.out.println("‧꒰ა ☆ ໒꒱{ L } Open Coin Grimoire ⋆˚.⋆   ✩  ╱|、 ");
            System.out.println("꒰ა ☆ ໒꒱{ X } Escape Apothecary  ₊˚.⋆  ✩  (˚ˎ 。7  ");
            System.out.println("  ─────────────۶ৎ─────────────            |、˜〵 ");
            System.out.println(" Please make selection:                   じしˍ,)ノ ");
            System.out.println("── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──── ⋆⋅☆⋅⋆ ──");

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
                    System.out.println("  ◌               ◌    ˚.⋆✩₊˚.⋆    ◌ ˚.⋆✩₊˚.⋆    ");
                    System.out.println("           ‧₊ *:･ﾟ彡       ◌       ☽      ◌");
                    System.out.println("        ◌            ✩彡 ･ﾟ *:           ");
                    System.out.println("                      ♡");
                    System.out.println("                 (\\_(\\       /)_/)");
                    System.out.println("                (     )     (     )");
                    System.out.println("                ૮/ʚɞ  |ა   ૮|  ʚɞ\\ა");
                    System.out.println("               ( ◌    |     |    ◌ )");
                    System.out.println("✧˚.⋆✩₊˚. the grimoire closes… until next time ˚.⋆✩₊˚.✧");
                    running = false; // stops the loop
                    break;

                default:
                    System.out.println("Invalid option");
            }

        }
//remember to close scanner at the end
        //scanner.close();

    }//end of main

}//end of public class