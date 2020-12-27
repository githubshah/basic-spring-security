package com.shah.springsecurity.jwt.repo;

public class MyUser {

    private String username;
    private String pass;
    private String userRole;
    private boolean active;

    public MyUser(String username, String pass, String userRole, boolean active) {
        this.username = username;
        this.pass = pass;
        this.userRole = userRole;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isActive() {
        return active;
    }
}
