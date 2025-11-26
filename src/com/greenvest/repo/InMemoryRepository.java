// temporary datasbase for the project
// store sustainability action and carbon credits in memory
//  allows to add, retrieve and search data


package com.greenvest.repo;

import com.greenvest.model.Credit;
import com.greenvest.model.SustainabilityAction;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository {

    //  list to store actions
    private List<SustainabilityAction> actions = new ArrayList<>();

    //  store credits
    private List<Credit> credits = new ArrayList<>();

    // add new action
    public void addAction(SustainabilityAction action) {
        actions.add(action);
    }

    // add credit
    public void addCredit(Credit credit) {
        credits.add(credit);
    }

    //  return action
    public List<SustainabilityAction> getActions() {
        return actions;
    }

    // return all credits
    public List<Credit> getAllCredits() {
        return credits;
    }

    //  find action using ID
    public SustainabilityAction findActionById(String id) {
        for (SustainabilityAction a : actions) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
}
