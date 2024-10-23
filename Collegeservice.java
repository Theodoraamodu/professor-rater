package com.example.pa.service;

import com.example.pa.model.college;
import com.example.pa.repository.Collegerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Collegeservice {

    @Autowired
    private Collegerepository collegeRepository;

    // Save a college
    public college saveCollege(college college) {
        return collegeRepository.save(college);
    }

    // Get all colleges
    public List<college> getAllColleges() {
        return collegeRepository.findAll();
    }

    // Get a college by ID
    public college getCollegeById(Long id) {
        Optional<college> result = collegeRepository.findById(id);
        return result.orElse(null);
    }

    // Delete a college by ID
    public void deleteCollege(Long id) {
        collegeRepository.deleteById(id);
    }
}
