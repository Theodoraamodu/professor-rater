package com.example.pa.Test;

import com.example.pa.model.feedback; // Ensure the correct import for your model
import com.example.pa.repository.Feedbackrepository; // Import your Feedback repository
import com.example.pa.service.Feedbackservice; // Import your Feedback service
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeedbackServiceTest {

    @InjectMocks
    private Feedbackservice feedbackService; // Your service class

    @Mock
    private Feedbackrepository feedbackRepository; // Mock the Feedback repository

    private feedback feedback; // Actual Feedback object to test

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        feedback = new feedback(); // Create a new Feedback instance
    }

    @Test
    public void testSaveFeedback() {
        // Given
        feedback.setFeedbackId(1L); // Set feedback id
        feedback.setProfessorId(1L); // Set professor id
        feedback.setCourseId(2L); // Set course id
        feedback.setUserId(3001); // Set user id
        feedback.setcategoryfId(1); // Set category id
        feedback.setRating(4); // Set rating
        feedback.setEdited(false); // Set edited flag
        feedback.setDeleted(false); // Set deleted flag

        // When
        feedbackService.saveFeedback(feedback); // Call your service method

        // Then
        verify(feedbackRepository, times(1)).save(feedback); // Verify the interaction with the repository
    }

    @Test
    public void testGetFeedbackById() {
        // Given
        long feedbackId = 1; // ID to search for
        when(feedbackRepository.findById(feedbackId)).thenReturn(Optional.of(feedback)); // Mock the repository response

        // When
        feedback foundFeedback = feedbackService.getFeedbackById(feedbackId); // Call your service method

        // Then
        verify(feedbackRepository, times(1)).findById(feedbackId); // Verify the repository interaction
        assertEquals(feedback, foundFeedback); // Assert that the found feedback is correct
    }

    @Test
    public void testGetAllFeedback() {
        // Given
        List<feedback> feedbackList = new ArrayList<>();
        feedbackList.add(feedback);
        when(feedbackRepository.findAll()).thenReturn(feedbackList); // Mock the repository response

        // When
        List<feedback> allFeedback = feedbackService.getAllFeedback(); // Call your service method

        // Then
        verify(feedbackRepository, times(1)).findAll(); // Verify the repository interaction
        assertEquals(1, allFeedback.size()); // Assert that the size of feedback list is correct
        assertEquals(feedback, allFeedback.get(0)); // Assert that the feedback is correct
    }

    @Test
    public void testDeleteFeedback() {
        // Given
        Long feedbackId = 1L; // ID to delete

        // When
        feedbackService.deleteFeedback(feedbackId); // Call your service method

        // Then
        verify(feedbackRepository, times(1)).deleteById(feedbackId); // Verify the interaction with the repository
    }
}
