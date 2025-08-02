// Department.java
package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int id;

    @Column(name="dept_name",length = 100, nullable = false)
    private String name;

    // Getters and setters
}