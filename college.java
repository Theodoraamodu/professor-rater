package com.example.pa.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class college {
@Id
private Long collegeId; // Unique identifier
private String collegeName; // Name of the college
private String location; // Location of the college

//Getters and setters
public Long getCollegeId() {
    return collegeId;
}

public void setCollegeId(Long collegeId) {
    this.collegeId = collegeId;
}

public String getCollegeName() {
    return collegeName;
}

public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

}
