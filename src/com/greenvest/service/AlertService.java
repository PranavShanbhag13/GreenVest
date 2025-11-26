// used to send alert when a carbon credit is near its expiry
//  receives information from ruleengine

package com.greenvest.service;

import com.greenvest.model.Credit;
import com.greenvest.patterns.CreditObserver;

public class AlertService implements CreditObserver {

    @Override
    public void update(Credit credit) {
        System.out.println("Alert: Credit " + credit.getId() + " is near expiry");
    }
}
