package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Dto.ProjectDto;
import com.example.EmployeeManagementSystem.Entity.Project;
import com.example.EmployeeManagementSystem.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(ProjectDto projectdto) {
        // Validate project data (e.g., check if project name is not null)
        if (projectdto.getName() == null) {
            throw new IllegalArgumentException("Project name cannot be null");
        }
        Project newProject = new Project();
        newProject.setName(projectdto.getName());
        newProject.setDescription(projectdto.getDescription());
        newProject.setStart_date(projectdto.getStartDate());
        newProject.setEnd_date(projectdto.getEndDate());

        // Save the project to the repository
        return projectRepository.save(newProject);
    }
    public Project getProjectById(int projectId) {
        // Fetch project by ID from the repository
        return projectRepository.findById(projectId).orElse(null); // Assuming findById returns an Optional
    }
    public Project updateProject(int projectId, ProjectDto projectDetails) {
        // Fetch the existing project
        Project existingProject = getProjectById(projectId);
        if (existingProject == null) {
            return null; // Project not found
        }

        // Update the project details
        existingProject.setName(projectDetails.getName());
        existingProject.setDescription(projectDetails.getDescription());
        existingProject.setStart_date(projectDetails.getStartDate());
        existingProject.setEnd_date(projectDetails.getEndDate());

        // Save the updated project
        return projectRepository.save(existingProject);
    }

    public void deleteProject(int projectId) {
        // Delete the project by ID
        projectRepository.deleteById(projectId);
    }
    public List<Project> getAllProjects() {
        // Fetch all projects from the repository
        return projectRepository.findAll(); // Assuming findAll() returns a list of projects
    }

}
