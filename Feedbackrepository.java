package com.example.pa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pa.model.feedback;

import java.util.List;

public interface Feedbackrepository extends JpaRepository<feedback, Long> {
	List<feedback> findByProfessorId(Long professorId);
    List<feedback> findByUserId(int userId);
}


