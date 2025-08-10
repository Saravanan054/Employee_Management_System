package com.example.EmployeeManagementSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectDto {
    private int employeeId;
    private int projectId;
    private String status;
}
