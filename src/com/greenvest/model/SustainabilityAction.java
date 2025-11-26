// sustainabity action submitted by the seller
//  stores action id, seller and their description
// also checks for approval


package com.greenvest.model;

public class SustainabilityAction {

    //  action details
    private String id;
    private String sellerId;
    private String description;
    private boolean approved;

    // constructor to create action
    public SustainabilityAction(String id, String sellerId, String description) {
        this.id = id;
        this.sellerId = sellerId;
        this.description = description;
        this.approved = false;
    }

    //  return ID, SellerID, Description, approval
    public String getId() { return id; }
    public String getSellerId() { return sellerId; }
    public String getDescription() { return description; }
    public boolean isApproved() { return approved; }

    // approval 
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
