package com.example.fptu.bean;

public class UserInfo {
    private String username;
    private String password;
    private String role;
    private String campus;

    public UserInfo(String username, String password, String role, String campus) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.campus = campus;
    }

    public UserInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
