//  main file for admin 
//  the application starts here and gives menu to admin
//  all services are connected here


package com.greenvest.admin;

import com.greenvest.model.SustainabilityAction;
import com.greenvest.repo.InMemoryRepository;
import com.greenvest.service.AdminService;
import com.greenvest.service.AlertService;
import com.greenvest.service.RuleEngineService;

import java.util.Scanner;

public class AdminController {

    public static void main(String[] args) {

        // /creates in-memory which acts as database
        InMemoryRepository repo = new InMemoryRepository();

        // sample actions
        repo.addAction(new SustainabilityAction("A1", "S1", "Installed solar panels"));
        repo.addAction(new SustainabilityAction("A2", "S2", "Planted 400 trees"));

        // creats admin service and command
        AdminService adminService = new AdminService(repo);
        AdminCommandInvoker invoker = new AdminCommandInvoker();

        // set up ruleengine and alert service
        RuleEngineService ruleEngine = new RuleEngineService();
        AlertService alertService = new AlertService();
        ruleEngine.register(alertService);

        // scanner for input
        try (Scanner sc = new Scanner(System.in)) {

            //  ask login details
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        

        //  verify admin login
        if (!adminService.login(username, password)) {
            System.out.println("Login failed.");
            return;
        }

        //  admin menu in loop
        while (true) {
            System.out.println("\n1. View pending actions");
            System.out.println("2. Approve action");
            System.out.println("3. View credits");
            System.out.println("4. Check alerts");
            System.out.println("5. View history");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice;

            // validating user choice
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }


            //  exit application
            if (choice == 0) break;

            //  switch for choice action 
            switch (choice) {
                case 1 -> adminService.showPendingActions();
                case 2 -> {
                    System.out.print("Action ID: ");
                    String id = sc.nextLine();
                    System.out.print("Credit amount: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Validity days: ");
                    int days = Integer.parseInt(sc.nextLine());
                    ApproveActionCommand cmd = new ApproveActionCommand(adminService, id, amount, days);
                    invoker.run(cmd);
                }
                case 3 -> adminService.showAllCredits();
                case 4 -> ruleEngine.checkExpiry(repo.getAllCredits());
                case 5 -> invoker.showHistory();
                default -> System.out.println("Invalid option.");
            }
        }

        //  message for exit
        System.out.println("Logged out.");
    }
}
} 
