package com.example.backEnd.university;

import com.example.backEnd.course.Course;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

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
    private int studentLimit2;
    private int numOfAppliedStudents;
    private int preferedSemester;
    @ElementCollection
    @CollectionTable()
    private Set<String> courseIdsList;
    private boolean isAvailable;
    private ArrayList<Integer>quota;
    
    public University(String universityName, int studentLimit, int studentLimit2, Set<String> courseIdsList, boolean isAvailable) {
        quota = new ArrayList<Integer>();
        this.universityName = universityName;
        this.studentLimit = studentLimit;
        this.courseIdsList = courseIdsList;
        this.isAvailable = isAvailable;
        this.studentLimit2 = studentLimit2;
        this.numOfAppliedStudents = 0;
        quota = new ArrayList<Integer>();
            quota.add(studentLimit);
            quota.add(studentLimit2);
            quota.add(Math.min(studentLimit, studentLimit2));
    }
    public University(String universityName, int studentLimit, int studentLimit2,  boolean isAvailable) {
        quota = new ArrayList<Integer>(3);
        quota.add(studentLimit);
        quota.add(studentLimit2);
        quota.add(Math.min(studentLimit, studentLimit2));
        this.universityName = universityName;
        this.studentLimit = studentLimit;
        this.courseIdsList = null;
        this.isAvailable = isAvailable;
        this.studentLimit2 = studentLimit2;
        this.numOfAppliedStudents = 0;

    }
    public University() {
        this.universityName = null;
        this.courseIdsList = null;
        this.numOfAppliedStudents = 0;
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
    public int getStudentLimit2() {
        return studentLimit2;    
    }
    public void setStudentLimit(int studentLimit) {
        this.studentLimit = studentLimit;
    }

    public Set<String> getCourseIdsList() {
        return courseIdsList;
    }

    public void setCourseIdsList(Set<String> courseIdsList) {
        this.courseIdsList = courseIdsList;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void addToCourseIdsList (String courseId) {
        courseIdsList.add(courseId);
    }
    public ArrayList<Integer> getQuota() {
        return this.quota;    
    }
    public void incrementNumofStudents() {
        this.numOfAppliedStudents++;    
    }
    public void setPreferedSemester(int set) {
        this.preferedSemester = set;    
    }
}
