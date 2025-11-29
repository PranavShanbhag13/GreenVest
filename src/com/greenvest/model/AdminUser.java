// this represents the admin user 
//  stores username and password used for login
//  used for verification of admn login


package com.greenvest.model;

import java.security.MessageDigest;

public class AdminUser {

    // admin user and password
    private String username;
    private String password;

    //  contructor to get username and password
    public AdminUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

     // OWASP constant-time comparison to prevent timing attacks
    public boolean safeEquals(String a, String b) {
        if (a == null || b == null) return false;
        return MessageDigest.isEqual(a.getBytes(), b.getBytes());
    }

     // Login method (needed for AdminService)
    public boolean checkLogin(String user, String pass) {
        return safeEquals(username, user) && safeEquals(password, pass);
    }


    public String getUsername() { 
        return username;
    }
    public String getPassword() {
        return password; 
    }

    
}
