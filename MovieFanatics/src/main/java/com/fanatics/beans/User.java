package com.fanatics.beans;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int    id;
    private String bio;
    
    
    public User() {}

    public User(String username, String password, String firstname, String lastname, int id, String bio) {
        super();
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.bio = bio;
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


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBio() {
        return bio;
    }


    public void setBio(String bio) {
        this.bio = bio;
    }
    

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
                + lastname + ", id=" + id + ", bio=" + bio + "]";
    }
    
}
