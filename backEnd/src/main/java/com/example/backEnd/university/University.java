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
    @OneToMany
    private Set<Course> courseList;
    private boolean isAvailable;

    public University(Long universityID, String universityName, int studentLimit, Set<Course> courseList, boolean isAvailable) {
        this.universityID = universityID;
        this.universityName = universityName;
        this.studentLimit = studentLimit;
        this.courseList = courseList;
        this.isAvailable = isAvailable;
    }

    public University() {
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

    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
