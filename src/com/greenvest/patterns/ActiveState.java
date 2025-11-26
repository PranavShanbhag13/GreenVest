package com.greenvest.patterns;

public class ActiveState {
    // return credit state
    public String getName() {
        return "ACTIVE";
    }

    public boolean canTrade() {
        return true;
    }
}
