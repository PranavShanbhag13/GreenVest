package com.greenvest.patterns;

public class ExpiredState {
    // get expiry message
    public String getName() {
        return "EXPIRED";
    }

    public boolean canTrade() {
        return false;
    }
}
