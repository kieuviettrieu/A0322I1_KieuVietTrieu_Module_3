package com.example.Casestudy.model;

public class User_Role {
    private int role_id;
    private String username;

    public User_Role() {
    }

    public User_Role(int role_id, String username) {
        this.role_id = role_id;
        this.username = username;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
