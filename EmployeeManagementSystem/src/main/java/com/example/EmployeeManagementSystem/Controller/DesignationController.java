package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Dto.DesignationDto;
import com.example.EmployeeManagementSystem.Entity.Designation;
import com.example.EmployeeManagementSystem.Services.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity<Designation> createDesignation(@RequestBody DesignationDto designationDto) {
        Designation designation = new Designation();
        designation.setName(designationDto.getName());
        Designation createdDesignation = designationService.createDesignation(designation);
        return ResponseEntity.ok(createdDesignation);
    }

    @GetMapping
    public ResponseEntity<List<Designation>> getAllDesignations() {
        List<Designation> designations = designationService.getAllDesignations();
        if (designations != null) {
            return ResponseEntity.ok(designations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Designation> getDesignationById(@PathVariable Integer id) {
        Designation designation = designationService.getDesignationById(id);
        if (designation != null) {
            return ResponseEntity.ok(designation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Designation> updateDesignation(@PathVariable Integer id, @RequestBody DesignationDto designationDto) {
        Designation updatedDesignation = designationService.updateDesignation(id, designationDto);
        if (updatedDesignation != null) {
            return ResponseEntity.ok(updatedDesignation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Integer id) {
        try {
            designationService.deleteDesignation(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
