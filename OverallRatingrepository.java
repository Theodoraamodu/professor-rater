package com.example.pa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pa.model.OverallRating;

import java.util.List;

public interface OverallRatingrepository extends JpaRepository<OverallRating, Long> {
    List<OverallRating> findByProfessorId(Long professorId);
    List<OverallRating> findByCourseId(Long courseId);
    List<OverallRating> findByCollegeId(Long collegeId);
}
