package com.RapidResQ.RapidResQ.Model;

public class AmbulanceUser {
private String userName;
private String password;

    public AmbulanceUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AmbulanceUser(String username, String password) {
        this.userName = username;
        this.password = password;
    }
}
