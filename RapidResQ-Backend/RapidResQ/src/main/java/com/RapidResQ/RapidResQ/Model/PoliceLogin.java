package com.RapidResQ.RapidResQ.Model;

public class PoliceLogin {
   private String userName;
   private String password;

    public PoliceLogin() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PoliceLogin(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
}

