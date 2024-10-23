package com.example.pa.Test;


import com.example.pa.model.OverallRating;
import com.example.pa.service.OverallRatingService;
import com.example.pa.repository.OverallRatingrepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OverallRatingServiceTest {

    @InjectMocks
    private OverallRatingService overallRatingService;

    @Mock
    private OverallRatingrepository overallRatingRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testGetAllOverallRatings() {
        // Given
        List<OverallRating> overallRatings = new ArrayList<>();
        overallRatings.add(new OverallRating(/* Initialize with sample data */));
        when(overallRatingRepository.findAll()).thenReturn(overallRatings);

        // When
        List<OverallRating> result = overallRatingService.getAllOverallRatings();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(overallRatingRepository, times(1)).findAll();
    }

    @Test
    public void testSaveOverallRating() {
        // Given
        OverallRating overallRating = new OverallRating(/* Initialize with sample data */);
        when(overallRatingRepository.save(overallRating)).thenReturn(overallRating);

        // When
        OverallRating result = overallRatingService.saveOverallRating(overallRating);

        // Then
        assertNotNull(result);
        verify(overallRatingRepository, times(1)).save(overallRating);
    }

    @Test
    public void testGetOverallRatingById() {
        // Given
        Long id = 1L;
        OverallRating overallRating = new OverallRating(); // Create a new OverallRating object
        overallRating.setId(id); // Set the ID to the expected value

        // Mock the repository method to return the overallRating when findById is called
        when(overallRatingRepository.findById(id)).thenReturn(java.util.Optional.of(overallRating));

        // When
        OverallRating result = overallRatingService.getOverallRatingById(id); // Call the service method

        // Then
        assertNotNull(result); // Ensure the result is not null
        assertEquals(id, result.getId()); // Ensure the ID matches the expected value
        verify(overallRatingRepository, times(1)).findById(id); // Verify the repository method was called
    }

    @Test
    public void testDeleteOverallRating() {
        // Given
        Long id = 1L;

        // When
        overallRatingService.deleteOverallRating(id);

        // Then
        verify(overallRatingRepository, times(1)).deleteById(id);
    }

    @Test
    public void testFindOverallRatingsByProfessorId() {
        // Given
        Long professorId = 1L;
        List<OverallRating> overallRatings = new ArrayList<>();
        overallRatings.add(new OverallRating(/* Initialize with sample data */));
        when(overallRatingRepository.findByProfessorId(professorId)).thenReturn(overallRatings);

        // When
        List<OverallRating> result = overallRatingService.findOverallRatingsByProfessorId(professorId);

        // Then
        assertEquals(1, result.size());
        verify(overallRatingRepository, times(1)).findByProfessorId(professorId);
    }

    @Test
    public void testFindOverallRatingsByCourseId() {
        // Given
        Long courseId = 1L;
        List<OverallRating> overallRatings = new ArrayList<>();
        overallRatings.add(new OverallRating(/* Initialize with sample data */));
        when(overallRatingRepository.findByCourseId(courseId)).thenReturn(overallRatings);

        // When
        List<OverallRating> result = overallRatingService.findOverallRatingsByCourseId(courseId);

        // Then
        assertEquals(1, result.size());
        verify(overallRatingRepository, times(1)).findByCourseId(courseId);
    }

    @Test
    public void testFindOverallRatingsByCollegeId() {
        // Given
        Long collegeId = 1L;
        List<OverallRating> overallRatings = new ArrayList<>();
        overallRatings.add(new OverallRating(/* Initialize with sample data */));
        when(overallRatingRepository.findByCollegeId(collegeId)).thenReturn(overallRatings);

        // When
        List<OverallRating> result = overallRatingService.findOverallRatingsByCollegeId(collegeId);

        // Then
        assertEquals(1, result.size());
        verify(overallRatingRepository, times(1)).findByCollegeId(collegeId);
    }
}

