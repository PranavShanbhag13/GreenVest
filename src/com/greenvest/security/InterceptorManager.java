// manage and run all interceptors in order
//  each interceptor check login repuest
// if interceptor returns false, login fails


package com.greenvest.security;

import java.util.ArrayList;
import java.util.List;

// run all interceptor
public class InterceptorManager {

    // run all interceptor
    private List<Interceptor> interceptors = new ArrayList<>();

    // add interceptor to the list 
    public void addInterceptor(Interceptor i) {
        interceptors.add(i);
    }

    //  run interceptor one at a time
    public boolean process(LoginRequest request) {
        for (Interceptor i : interceptors) {
            // if failed stop login
            if (!i.handle(request)) {
                return false;
            }
        }
        return true;
    }
}
