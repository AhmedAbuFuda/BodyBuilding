package com.example.fragments;

import androidx.annotation.NonNull;

public class User {
    private String uid;
    private String firstName;
    private String secondName;
    private String weight;
    private String height;
    private String email;

    public User() {
    }

    public User(String uid, String firstName, String secondName, String weight, String height, String email) {
        this.uid = uid;
        this.firstName = firstName;
        this.secondName = secondName;
        this.weight = weight;
        this.height = height;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getheight() {
        return height;
    }

    public void setheight(String height) {
        height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

