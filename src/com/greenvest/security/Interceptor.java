//  Interface for interceptor login process
//  all login request are handled here

package com.greenvest.security;

public interface Interceptor {
    boolean handle(LoginRequest request);
}
