package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Dto.EmployeeProjectDto;
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Entity.EmployeeProject;
import com.example.EmployeeManagementSystem.Entity.Project;
import com.example.EmployeeManagementSystem.Repository.EmployeeProjectRepository;
import com.example.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;

    public EmployeeProject assignEmployeeToProject(EmployeeProjectDto employeeprojectdto) {
        // Validate employee and project existence
        Employee employee=employeeService.getEmployeeById(employeeprojectdto.getEmployeeId());
        if (employee == null) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeprojectdto.getEmployeeId());
        }
        Project project = projectService.getProjectById(employeeprojectdto.getProjectId());
        if (project == null) {
            throw new IllegalArgumentException("Project not found with ID: " + employeeprojectdto.getProjectId());
        }
        // Create a new EmployeeProject entity
        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);
        employeeProject.setTask_status(employeeprojectdto.getStatus());
        // Save the association
        return employeeProjectRepository.save(employeeProject);
    }

    public List<EmployeeProject> getAllEmployeeProjects() {
        // Fetch all employee-project associations
        return employeeProjectRepository.findAll();
    }

    public EmployeeProject getEmployeeProjectById(int id) {
        // Fetch employee-project association by ID
        return employeeProjectRepository.findById(id).orElse(null);
    }

    public EmployeeProject updateEmployeeProject(int id, EmployeeProjectDto employeeprojectdto) {
        // Fetch the existing association
        EmployeeProject existingEmployeeProject = getEmployeeProjectById(id);
        if (existingEmployeeProject == null) {
            return null; // Association not found
        }
        Employee employee=employeeService.getEmployeeById(employeeprojectdto.getEmployeeId());
        if (employee == null) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeprojectdto.getEmployeeId());
        }
        Project project = projectService.getProjectById(employeeprojectdto.getProjectId());
        if (project == null) {
            throw new IllegalArgumentException("Project not found with ID: " + employeeprojectdto.getProjectId());
        }
        existingEmployeeProject.setEmployee(employee);
        existingEmployeeProject.setProject(project);
        // Update the fields
        existingEmployeeProject.setTask_status(employeeprojectdto.getStatus());
        // Save the updated association
        return employeeProjectRepository.save(existingEmployeeProject);
    }

    public void deleteEmployeeProject(int id) {
        // Fetch the existing association
        EmployeeProject existingEmployeeProject = getEmployeeProjectById(id);
        if (existingEmployeeProject != null) {
            // Delete the association
            employeeProjectRepository.delete(existingEmployeeProject);
        } else {
            throw new IllegalArgumentException("Employee-Project association not found with ID: " + id);
        }
    }

}
