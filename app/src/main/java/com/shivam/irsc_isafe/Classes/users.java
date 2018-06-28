package com.shivam.irsc_isafe.Classes;

public class users {
    String name;
    String password;
    String city;
    String college;
    String email;
    String contactnumber;
    String teamcode;


    public users(){

    }

    public users(String name, String password, String city, String college, String email, String contactnumber, String teamcode) {
        this.name = name;
        this.password = password;
        this.city = city;
        this.college = college;
        this.email = email;
        this.contactnumber = contactnumber;
        this.teamcode = teamcode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode;
    }
}
