// interface for subject in the observer pattern
//  registers and notifies observer for changes


package com.greenvest.patterns;

public interface CreditSubject {
    void register(CreditObserver observer);
    void remove(CreditObserver observer);
    void notifyObservers();
}
