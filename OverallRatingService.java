package com.example.pa.service;

import com.example.pa.model.OverallRating;
import com.example.pa.repository.OverallRatingrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverallRatingService {

    @Autowired
    private OverallRatingrepository overallRatingRepository;

    // Get all overall ratings
    public List<OverallRating> getAllOverallRatings() {
        return overallRatingRepository.findAll();
    }

    // Save overall rating
    public OverallRating saveOverallRating(OverallRating overallRating) {
        return overallRatingRepository.save(overallRating);
    }

    // Get overall rating by ID
    public OverallRating getOverallRatingById(Long id) {
        return overallRatingRepository.findById(id).orElse(null);
    }
    
    // Custom query to find overall ratings by professor ID
    public List<OverallRating> findOverallRatingsByProfessorId(Long professorId) {
        return overallRatingRepository.findByProfessorId(professorId);
    }
    
 // Custom query to find overall ratings by course ID
    public List<OverallRating> findOverallRatingsByCourseId(Long courseId) {
        return overallRatingRepository.findByCourseId(courseId);
    }
    
    // Custom query to find overall ratings by college ID
    public List<OverallRating> findOverallRatingsByCollegeId(Long collegeId) {
        return overallRatingRepository.findByCollegeId(collegeId);
    }

    // Delete overall rating
    public void deleteOverallRating(Long id) {
        overallRatingRepository.deleteById(id);
    }
}

