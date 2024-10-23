package com.example.pa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class feedback {
    @Id
    private Long feedbackId; // Unique identifier for the feedback
    private Long professorId; // Associated professor's ID
    private Long courseId; // Associated course's ID
    private int userId; // ID of the user who provided feedback
    private int categoryfId; // ID of the feedback category
    private int rating; // Rating given by the user
    private boolean isEdited; // Indicates if feedback has been edited
    private boolean isDeleted; // Indicates if feedback has been deleted

    // Getters and setters
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getcategoryfId() {
        return categoryfId;
    }

    public void setcategoryfId(int categoryfId) {
        this.categoryfId = categoryfId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}

