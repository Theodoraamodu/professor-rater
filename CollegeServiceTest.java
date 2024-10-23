package com.example.pa.Test;

import com.example.pa.model.college;
import com.example.pa.service.Collegeservice;
import com.example.pa.repository.Collegerepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollegeServiceTest {

    @InjectMocks
    private Collegeservice collegeService;

    @Mock
    private Collegerepository collegeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllColleges() {
        // Given
        List<college> colleges = new ArrayList<>();
        colleges.add(new college());
        when(collegeRepository.findAll()).thenReturn(colleges);

        // When
        List<college> result = collegeService.getAllColleges();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(collegeRepository, times(1)).findAll();
    }

    @Test
    public void testSaveCollege() {
        // Given
        college myCollege = new college();
        myCollege.setCollegeId(1L);
        myCollege.setCollegeName("Douglas College");
        myCollege.setLocation("New Westminster");
        when(collegeRepository.save(myCollege)).thenReturn(myCollege);

        // When
        college result = collegeService.saveCollege(myCollege);

        // Then
        assertNotNull(result);
        verify(collegeRepository, times(1)).save(myCollege);
    }

    @Test
    public void testGetCollegeById() {
        // Given
        Long id = 1L;
        college myCollege = new college();
        myCollege.setCollegeId(id);
        when(collegeRepository.findById(id)).thenReturn(Optional.of(myCollege));

        // When
        college result = collegeService.getCollegeById(id);

        // Then
        assertNotNull(result);
        assertEquals(id, result.getCollegeId());
        verify(collegeRepository, times(1)).findById(id);
    }

    @Test
    public void testDeleteCollege() {
        // Given
        Long id = 1L;

        // When
        collegeService.deleteCollege(id);

        // Then
        verify(collegeRepository, times(1)).deleteById(id);
    }
}
