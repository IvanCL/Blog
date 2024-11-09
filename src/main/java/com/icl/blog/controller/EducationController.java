package com.icl.blog.controller;

import com.icl.blog.model.Education;
import com.icl.blog.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private final EducationService educationService;

   @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable Long id) {
        Optional<Education> education = educationService.getEducationById(id);
        return education.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationService.createEducation(education);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education educationDetails) {
        return ResponseEntity.ok(educationService.updateEducation(id, educationDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.noContent().build();
    }
}

