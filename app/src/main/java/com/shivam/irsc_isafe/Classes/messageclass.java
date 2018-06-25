package com.shivam.irsc_isafe.Classes;

public class messageclass {

    String message;
    String user;

    public messageclass(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public messageclass() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
