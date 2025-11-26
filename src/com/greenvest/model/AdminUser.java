// this represents the admin user 
//  stores username and password used for login
//  used for verification of admn login


package com.greenvest.model;

public class AdminUser {

    // admin user and password
    private String username;
    private String password;

    //  contructor to get username and password
    public AdminUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //  check login
    public boolean checkLogin(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
}
