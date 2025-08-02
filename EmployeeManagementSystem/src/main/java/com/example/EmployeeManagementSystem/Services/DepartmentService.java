package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Entity.Department;
import com.example.EmployeeManagementSystem.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }
    public Department updateDepartment(int id, Department department) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        existingDepartment.setName(department.getName());
//        existingDepartment.setDescription(department.getDescription());
        return departmentRepository.save(existingDepartment);
    }
    public void deleteDepartment(int id) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.delete(existingDepartment);
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentByName(String name) {
        return departmentRepository.findAll().stream()
                .filter(department -> department.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Department not found with name: " + name));
    }
}
