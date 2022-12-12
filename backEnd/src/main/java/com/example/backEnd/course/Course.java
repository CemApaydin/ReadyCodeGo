package com.example.backEnd.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="course")
@Data
@CrossOrigin
public class Course {
    @Id
    private String courseID;
    private String courseName;
    private double ECTS;

    public Course(String courseID, String courseName, double ECTS) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.ECTS = ECTS;
    }

    public Course() {
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getECTS() {
        return ECTS;
    }

    public void setECTS(double ECTS) {
        this.ECTS = ECTS;
    }
}
