package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Entity.User;
import com.example.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeManagementSystem.Dto.EmployeeDto;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DesignationService designationService;
    @Autowired
    private DepartmentService departmentService;

    public Employee createEmployee(EmployeeDto employee) {
        // Validate the employee object if necessary
        if (employee == null || employee.getName() == null || employee.getName().isEmpty() || employee.getUserId() == null) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        User user = userRepository.findById(employee.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + employee.getUserId()));
        if (!user.getRole().equals("employee")) {
            throw new IllegalArgumentException("Role must be 'employee'");
        }
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setDepartment(departmentService.getDepartmentByName(employee.getDepartmentName()));
        newEmployee.setDesignation(designationService.getDesignationByName(employee.getDesignationName()));
        newEmployee.setDoj(employee.getDoj());
        newEmployee.setStatus(employee.getStatus());
        newEmployee.setUser(user);
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getAllEmployees() {
        // Fetch all employees from the repository
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        // Fetch employee by ID from the repository
        return employeeRepository.findById(employeeId).orElse(null); // Assuming findById returns an Optional
    }

    public Employee updateEmployee(int employeeId, EmployeeDto employeeDetails) {
        // Fetch the existing employee
        Employee existingEmployee = getEmployeeById(employeeId);
        if (existingEmployee == null) {
            return null; // Employee not found
        }

        // Update the employee details
        existingEmployee.setName(employeeDetails.getName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPhone(employeeDetails.getPhone());
        existingEmployee.setDepartment(departmentService.getDepartmentByName(employeeDetails.getDepartmentName()));
        existingEmployee.setDesignation(designationService.getDesignationByName(employeeDetails.getDesignationName()));
        existingEmployee.setDoj(employeeDetails.getDoj());
        existingEmployee.setStatus(employeeDetails.getStatus());

        // Save the updated employee
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(int employeeId) {
        // Delete the employee by ID
        employeeRepository.deleteById(employeeId);
    }
}
