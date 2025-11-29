//  logs every login attempt
//  mainly used for auditing and basic intrusion detection( OSWAP practice)
// can never block only record
package com.greenvest.security;

//  log each login
public class LoggingInterceptor implements Interceptor {

    @Override
    public boolean handle(LoginRequest request) {

        //  print username for logging
        System.out.println("[LOGIN] Attempt by: " + request.getUsername());

        //  always true so as to not block
        return true; 
    }
}
