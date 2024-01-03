package com.fishybusiness.afishybusiness.Models;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
@Access(value = AccessType.FIELD)
public class User {
    @Id
    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "password", unique = false, nullable = false)
    String password;

    @Column(name = "admin", unique = false, nullable = false)
    int admin = 0;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User {\n" +
                "email: " + email + "\n" +
                "password: " + password + "\n" +
                "admin: " + admin + "\n" +
                "}";
    }
}
