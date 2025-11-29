// checks if the admin login details are correct
// uses safe comparison to prevent timing attacks( OSWAP practice)
// If authentication fails, the login process stops.

package com.greenvest.security;

import com.greenvest.model.AdminUser;

// verify login
public class AuthenticationInterceptor implements Interceptor {

    private AdminUser admin;

    public AuthenticationInterceptor(AdminUser admin) {
        this.admin = admin;
    }

    @Override
    public boolean handle(LoginRequest request) {

        // OWASP: avoid timing attacks by using constant-time comparison
        boolean userOK = admin.safeEquals(admin.getUsername(), request.getUsername());
        boolean passOK = admin.safeEquals(admin.getPassword(), request.getPassword());

        // allow if both match
        return userOK && passOK;
    }
}
