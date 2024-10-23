package com.example.pa.controller;


import com.example.pa.model.OverallRating;
import com.example.pa.service.OverallRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/overallRatings")
public class OverallRatingController {

    @Autowired
    private OverallRatingService overallRatingService;

    // Get all overall ratings
    @GetMapping
    public List<OverallRating> getAllOverallRatings() {
        return overallRatingService.getAllOverallRatings();
    }

 // Get overall rating by ID
    @GetMapping("/{id}")
    public ResponseEntity<OverallRating> getOverallRatingById(@PathVariable Long id) {
        OverallRating overallRating = overallRatingService.getOverallRatingById(id);
        if (overallRating == null) {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
        return ResponseEntity.ok(overallRating);
    }
    
 // Get overall ratings by professor ID
    @GetMapping("/professor/{professorId}")
    public List<OverallRating> getOverallRatingsByProfessorId(@PathVariable Long professorId) {
        return overallRatingService.findOverallRatingsByProfessorId(professorId);
    }

    // Get overall ratings by course ID
    @GetMapping("/course/{courseId}")
    public List<OverallRating> getOverallRatingsByCourseId(@PathVariable Long courseId) {
        return overallRatingService.findOverallRatingsByCourseId(courseId);
    }

    // Get overall ratings by college ID
    @GetMapping("/college/{collegeId}")
    public List<OverallRating> getOverallRatingsByCollegeId(@PathVariable Long collegeId) {
        return overallRatingService.findOverallRatingsByCollegeId(collegeId);
    }



    // Create new overall rating
    @PostMapping
    public OverallRating createOverallRating(@RequestBody OverallRating overallRating) {
        return overallRatingService.saveOverallRating(overallRating);
    }

    // Delete overall rating
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOverallRating(@PathVariable Long id) {
        overallRatingService.deleteOverallRating(id);
        return ResponseEntity.noContent().build();
    }
}
