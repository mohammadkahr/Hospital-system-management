package com.company;

public class User {
    private String name;
    private int id;
    private String password;
    private String phoneNumber;
    private String email;

    public User(String name, int id, String password, String phoneNumber, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
