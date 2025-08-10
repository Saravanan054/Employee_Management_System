package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Dto.EmployeeProjectDto;
import com.example.EmployeeManagementSystem.Entity.EmployeeProject;
import com.example.EmployeeManagementSystem.Services.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/employee-projects"})
public class EmployeeProjectController {
    @Autowired
    private EmployeeProjectService employeeProjectService;

    @PostMapping
    public ResponseEntity<EmployeeProject> assignEmployeeToProject(@RequestBody EmployeeProjectDto employeeProjectdto) {
        System.out.println("Assigning employee to project: " + employeeProjectdto.getEmployeeId()+ " to project: " + employeeProjectdto.getProjectId());
        EmployeeProject createdEmployeeProject = employeeProjectService.assignEmployeeToProject(employeeProjectdto);
        return ResponseEntity.ok(createdEmployeeProject);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProject>> getAllEmployeeProjects() {
        List<EmployeeProject> employeeProjects = employeeProjectService.getAllEmployeeProjects();
        if (employeeProjects != null && !employeeProjects.isEmpty()) {
            return ResponseEntity.ok(employeeProjects);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProject> getEmployeeProjectById(@PathVariable int id) {
        EmployeeProject employeeProject = employeeProjectService.getEmployeeProjectById(id);
        if (employeeProject != null) {
            return ResponseEntity.ok(employeeProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeProject> updateEmployeeProject(@PathVariable int id,@RequestBody EmployeeProjectDto employeeProjectdto) {
        EmployeeProject updatedEmployeeProject = employeeProjectService.updateEmployeeProject(id, employeeProjectdto);
        if (updatedEmployeeProject != null) {
            return ResponseEntity.ok(updatedEmployeeProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeProject(@PathVariable int id) {
        EmployeeProject existingEmployeeProject = employeeProjectService.getEmployeeProjectById(id);
        if (existingEmployeeProject != null) {
            employeeProjectService.deleteEmployeeProject(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
