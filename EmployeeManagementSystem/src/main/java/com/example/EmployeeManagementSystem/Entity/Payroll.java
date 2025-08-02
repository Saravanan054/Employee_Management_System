// Payroll.java
package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payroll")
@Getter
@Setter
@AllArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name="month",length = 20)
    private String month;

    @Column(name="base_salary")
    private Double base_salary;

    @Column(name="deductions")
    private Double deductions;

    @Column(name="bonus")
    private Double bonus;

    @Column(name="net_salary")
    private Double net_salary;

    // Getters and setters
}