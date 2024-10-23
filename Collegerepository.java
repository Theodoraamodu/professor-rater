package com.example.pa.repository;


import com.example.pa.model.college;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Collegerepository extends JpaRepository<college, Long> {
}



