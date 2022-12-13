package com.example.backEnd.university;

import com.example.backEnd.course.Course;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="university")
@Data
@CrossOrigin
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityID;
    private String universityName;
    private int studentLimit;
    @ElementCollection
    private Set<Long> courseIdsList;
    private boolean isAvailable;

    public University(String universityName, int studentLimit, Set<Long> courseIdsList, boolean isAvailable) {
        this.universityName = universityName;
        this.studentLimit = studentLimit;
        this.courseIdsList = courseIdsList;
        this.isAvailable = isAvailable;
    }

    public University() {
        this.universityName = null;
        this.courseIdsList = null;
    }

    public Long getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Long universityID) {
        this.universityID = universityID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getStudentLimit() {
        return studentLimit;
    }

    public void setStudentLimit(int studentLimit) {
        this.studentLimit = studentLimit;
    }

    public Set<Long> getCourseIdsList() {
        return courseIdsList;
    }

    public void setCourseIdsList(Set<Long> courseIdsList) {
        this.courseIdsList = courseIdsList;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
