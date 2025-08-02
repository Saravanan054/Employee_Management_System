package com.example.EmployeeManagementSystem.Services;

import com.example.EmployeeManagementSystem.Dto.DesignationDto;
import com.example.EmployeeManagementSystem.Entity.Designation;
import com.example.EmployeeManagementSystem.Repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    public Designation createDesignation(Designation designation) {
        return designationRepository.save(designation);
    }

    public Designation updateDesignation(Integer id, DesignationDto designationDto) {
        Designation designation = designationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Designation not found"));
        designation.setName(designationDto.getName());
        return designationRepository.save(designation);
    }
    public void deleteDesignation(Integer id) {
        Designation designation = designationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Designation not found"));
        designationRepository.delete(designation);
    }
    public Designation getDesignationById(Integer id) {
        return designationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Designation not found"));
    }
    public List<Designation> getAllDesignations() {
        return designationRepository.findAll();
    }
    //get designation by name
    public Designation getDesignationByName(String name) {
        return designationRepository.findAll().stream()
                .filter(designation -> designation.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Designation not found with name: " + name));
    }
}
