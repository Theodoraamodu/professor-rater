package com.example.pa.controller;

import com.example.pa.model.college;
import com.example.pa.service.Collegeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private Collegeservice collegeService;

    // Create a new college
    @PostMapping
    public ResponseEntity<college> createCollege(@RequestBody college college) {
        college savedCollege = collegeService.saveCollege(college);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }

    // Retrieve all colleges
    @GetMapping
    public ResponseEntity<List<college>> getAllColleges() {
        List<college> colleges = collegeService.getAllColleges();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    // Retrieve a single college by ID
    @GetMapping("/{id}")
    public ResponseEntity<college> getCollegeById(@PathVariable Long id) {
        college college = collegeService.getCollegeById(id);
        if (college != null) {
            return new ResponseEntity<>(college, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a college by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
