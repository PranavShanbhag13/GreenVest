// contains the main business logic for admin
// validates the admin login


package com.greenvest.service;

import com.greenvest.model.AdminUser;
import com.greenvest.model.Credit;
import com.greenvest.model.SustainabilityAction;
import com.greenvest.repo.InMemoryRepository;

public class AdminService {

    // access inmemory
    private InMemoryRepository repo;

    // admin user details
    private AdminUser admin = new AdminUser("admin","admin");

    // constructor
    public AdminService(InMemoryRepository repo) {
        this.repo = repo;
    }

    //  verify admin
    public boolean login(String user, String pass) {
        return admin.checkLogin(user, pass);
    }

    // actions that are not approved
    public void showPendingActions() {
        for (SustainabilityAction a : repo.getActions()) {
            if (!a.isApproved()) {
                System.out.println(a.getId() + " - " + a.getDescription());
            }
        }
    }

    //  approves actiona and create credit
    public void approveAction(String id, double amount, int days) {
        // find sustainability action
        SustainabilityAction action = repo.findActionById(id);

        //  id action exists or is approved 
        if (action == null || action.isApproved()) {
            System.out.println("Invalid action.");
            return;
        }

        //  mark approved
        action.setApproved(true);

        // create credit usinf factory method
        Credit credit = CreditFactory.create(amount, days);

        //  store the credit
        repo.addCredit(credit);

        // confirmatin
        System.out.println("Approved " + id + " and issued credit " + credit.getId());
    }

    //  displays all credits
    public void showAllCredits() {
        for (Credit c : repo.getAllCredits()) {
            System.out.println(
                    c.getId() + " | " +
                    c.getAmount() + " | " +
                    c.getExpiryDate() + " | " +
                    c.getStatus()
            );
        }
    }
}
