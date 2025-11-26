//  represents carbon credit
//  stores credit ID, amount and expiry date
// check whether credit is active or expired

package com.greenvest.model;

import java.time.LocalDate;

public class Credit {

    //  credit details
    private String id;
    private double amount;
    private LocalDate expiryDate;
    private String status;

    //  constructor to create credit
    public Credit(String id, double amount, LocalDate expiryDate) {
        this.id = id;
        this.amount = amount;
        this.expiryDate = expiryDate;
        updateStatus();
    }

    //  return ID, amount and expiry of credit
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public LocalDate getExpiryDate() { return expiryDate; }

    //  update credit status
    public void updateStatus() {
        if (expiryDate.isBefore(LocalDate.now())) {
            status = "EXPIRED";
        } else {
            status = "ACTIVE";
        }
    }

    // return credit status
    public String getStatus() {
        updateStatus();
        return status;
    }
}
