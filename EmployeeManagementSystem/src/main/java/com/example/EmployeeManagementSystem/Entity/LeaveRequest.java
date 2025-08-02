// LeaveRequest.java
package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "leave_requests")
@Getter
@Setter
@AllArgsConstructor
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name="leave_type",length = 45)
    private String type;

    @Temporal(TemporalType.DATE)
    private Date from_date;

    @Temporal(TemporalType.DATE)
    private Date to_date;

    @Column(name="reason",length = 255)
    private String reason;

    @Column(name="status",length = 45)
    private String status;

    // Getters and setters
}