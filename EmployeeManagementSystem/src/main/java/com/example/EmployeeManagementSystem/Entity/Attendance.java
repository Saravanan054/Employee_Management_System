// Attendance.java
package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import com.example.EmployeeManagementSystem.Entity.Employee;
@Entity
@Table(name = "attendance")
@Getter
@Setter

public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="clock_in", length = 20)
    private String clock_in;

    @Column(name="clock_out", length = 20)
    private String clock_out;

    @Column(name="total_hours")
    private Double total_hours;
    // Getters and setters
}