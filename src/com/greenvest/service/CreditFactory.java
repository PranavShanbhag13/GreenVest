// used to create new carbon credit objects
//  automatically generates a uuid and calculates the expiry date
// uses factory design pattern

package com.greenvest.service;

import com.greenvest.model.Credit;
import java.time.LocalDate;
import java.util.UUID;

public class CreditFactory {

    public static Credit create(double amount, int days) {

        // create UUID of 8 and check expiry
        String id = "CR-" +
                UUID.randomUUID().toString().substring(0,6).toUpperCase();

        LocalDate expiry = LocalDate.now().plusDays(days);

        return new Credit(id, amount, expiry);
    }
}
