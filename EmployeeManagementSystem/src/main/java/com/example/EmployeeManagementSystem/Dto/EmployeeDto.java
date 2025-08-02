package com.example.EmployeeManagementSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String email;
    private String phone;
    private String departmentName;
    private String designationName;
    private Date doj;
    private String status;
    private Integer userId;
}
