package com.example.EmployeeManagementSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private String Name;
    private String Description;
    private Date startDate;
    private Date endDate;

}
