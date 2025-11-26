// checks business rules for carbon credits
//  check for date of expiry for each credit
// if close to expiry it informs AlterService

package com.greenvest.service;

import com.greenvest.model.Credit;
import com.greenvest.patterns.CreditObserver;
import com.greenvest.patterns.CreditSubject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RuleEngineService implements CreditSubject {

    //  list of observer to notify
    private List<CreditObserver> observers = new ArrayList<>();
   
    // credit to check
    private Credit currentCredit;

    // add observer
    @Override
    public void register(CreditObserver observer) {
        observers.add(observer);
    }

    // remove observer
    @Override
    public void remove(CreditObserver observer) {
        observers.remove(observer);
    }
    
    // notify observers
    @Override
    public void notifyObservers() {
        for (CreditObserver o : observers) {
            o.update(currentCredit);
        }
    }

    // check credit expiry
    public void checkExpiry(List<Credit> credits) {
        for (Credit c : credits) {
            if (c.getExpiryDate().isBefore(LocalDate.now().plusDays(3))) {
                currentCredit = c;
                notifyObservers();
            }
        }
    }
}
