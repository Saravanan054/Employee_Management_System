// Announcement.java
package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "announcements")
@Getter
@Setter
@AllArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title",length = 100, nullable = false)
    private String title;

    @Column(name="content",length = 1000)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    // Getters and setters
}