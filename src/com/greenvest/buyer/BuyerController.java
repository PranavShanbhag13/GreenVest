package com.greenvest.buyer;

import java.util.Scanner;

public class BuyerController {
    private BuyerService buyerService = new BuyerService();
    public static void main(String[] args) {
        new BuyerController().showMenu();
    }
    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("=== Buyer Menu ===");
            System.out.println("1. Login");
            System.out.println("2. View Credits ");
            System.out.println("3. Buy Credits ");
            System.out.println("4. View Purchased Credits ");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println(" Username ");
                    String username = scanner.next();
                    System.out.println(" Password ");
                    String password = scanner.next();
                    buyerService.login(username, password);
                    break;
                case 2:
                    buyerService.listAvailableCredits();
                    break;
                case 3: ;
                    System.out.println("Enter credit ID");
                    String creditID = scanner.next();
                    buyerService.buyCredit(creditID);
                    break;
                case 4:
                     buyerService.listPurchasedCredits();
                     break;
                case 0:
                    System.out.println(" Exiting...");
                    return;
                default: System.out.println(" Try again, Invalid Option."); break;
            }

        }
    }

}

