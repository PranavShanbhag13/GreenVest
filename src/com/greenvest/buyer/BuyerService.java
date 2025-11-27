package com.greenvest.buyer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.greenvest.model.Credit;
import com.greenvest.patterns.CreditFactory;

public class BuyerService {
    private boolean loggedIn = false;
    public void login(String username, String password) {
        loggedIn = true;
        System.out.println("Buyer Logged in");
    }
    private boolean checkLoggedIn(){
        if(!loggedIn){
            System.out.println("You must be logged in to perform this actions");
            return false;
        }
        return true;
    }
    private List<Credit> availableCredit = new ArrayList<>();
    private List<Credit> purchasedCredit = new ArrayList<>();


    public BuyerService() {
        availableCredit.add(CreditFactory.createStandardCredit("CR1", 100.0, 10));
        availableCredit.add(CreditFactory.createStandardCredit("CR2", 100.0, 15));
        availableCredit.add(new Credit("CR3", 200.0, LocalDate.now().plusDays(20)));
    }

    public void listAvailableCredits() {
        if(!loggedIn){
            return; // buyer must be logged in
        }
        System.out.println("---- Available Credits ----");
        for (Credit credit : availableCredit) {
            if("ACTIVE".equals(credit.getStatus())) { // Invariant only active credits would be shown
                System.out.println(credit.getId() + " " + credit.getAmount() + " " + credit.getExpiryDate() + " " + credit.getStatus());
            }
        }
    }

    public void buyCredit(String creditId) {
        if(!loggedIn){
            return;
        }
        Credit found = null;
        for (Credit credit : availableCredit) {
            if (credit.getId().equalsIgnoreCase(creditId)) {
                found = credit;
                break;
            }
        }
        if (found == null) {
            System.out.println("Credit not found");
            return;
        }
        availableCredit.remove(found);
        purchasedCredit.add(found);
        System.out.println("Bought Credit: " + found.getId());
    }

    public void listPurchasedCredits() {
        if(!loggedIn){
            return;
        }
        System.out.println("---- Purchased Credits ----");
        if (purchasedCredit.isEmpty()) {
            System.out.println("Credits not bought yet");
        } else {
            for (Credit credit : purchasedCredit) {
                System.out.println(credit.getId() + " " + credit.getAmount() + " " + credit.getExpiryDate());
            }
        }
    }
}


