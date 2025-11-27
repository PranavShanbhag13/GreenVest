package com.greenvest.patterns;

import com.greenvest.model.Credit;

import java.time.LocalDate;

public class CreditFactory {
    public static Credit createStandardCredit (String id, double amount, int validDays){
        LocalDate expiry = LocalDate.now().plusDays(validDays);
        return new Credit(id, amount, expiry);
    }
}
