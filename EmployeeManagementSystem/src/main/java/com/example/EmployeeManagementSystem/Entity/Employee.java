// Employee.java
package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name="employee_name",length = 100, nullable = false)
    private String name;

    @Column(name="email",length = 100, nullable = false)
    private String email;

    @Column(name="phone_no",length = 20)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @Temporal(TemporalType.DATE)
    private Date doj;

    @Column(name="status",length = 20)
    private String status;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;
    // Getters and setters
}