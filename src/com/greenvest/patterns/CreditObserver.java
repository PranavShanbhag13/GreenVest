//  interface obeserver pattern 
//  class that wants to receive the credit expiry must implement this interface

package com.greenvest.patterns;

import com.greenvest.model.Credit;

public interface CreditObserver {
    void update(Credit credit);
}
