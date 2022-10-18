package com.example.booklibrary.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Id
    private long id;
    private String username;
    private String password;

}
