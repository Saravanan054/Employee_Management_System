package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;

    @Column(name = "username", length = 45, nullable = false)
    private String username;

    @Column(name = "password", length = 45, nullable = false)
    private String password;

    @Column(name = "role", length = 45, nullable = false,
            columnDefinition = "VARCHAR(45) CHECK (role IN ('admin', 'employee'))")
    private String role;

    // Default constructor
    public User() {
    }
    // Parameterized constructor
    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }
    // Getters and setters

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
}