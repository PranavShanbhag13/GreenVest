// this is to approve the sustainability action
// It stores the action details and sends them to the AdminService to be processed.

package com.greenvest.admin;

import com.greenvest.patterns.AdminCommand;
import com.greenvest.service.AdminService;

public class ApproveActionCommand implements AdminCommand {

    // access service approve action 
    private AdminService service;

    // access action details
    private String actionId;
    private double amount;
    private int days;

    // constructor
    public ApproveActionCommand(AdminService service, String actionId, double amount, int days) {
        this.service = service;
        this.actionId = actionId;
        this.amount = amount;
        this.days = days;
    }

    //  approval logic
    @Override
    public void execute() {
        service.approveAction(actionId, amount, days);
    }

    //  return name for command history
    @Override
    public String getName() {
        return "ApproveAction(" + actionId + ")";
    }
}
