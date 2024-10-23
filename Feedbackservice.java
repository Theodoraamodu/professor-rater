package com.example.pa.service;


import com.example.pa.model.feedback;
import com.example.pa.repository.Feedbackrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Feedbackservice {

    @Autowired
    private Feedbackrepository feedbackRepository;

    // Get all feedback
    public List<feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // Save feedback
    public feedback saveFeedback(feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get feedback by ID
    public feedback getFeedbackById(Long i) {
        return feedbackRepository.findById(i).orElse(null);
    }

    // Delete feedback
    public void deleteFeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    // Custom query example (Add more as needed)
    public List<feedback> findFeedbackByProfessorId(Long professorId) {
        return feedbackRepository.findByProfessorId(professorId);
    }
}

