package com.example.backEnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="bilkentcourse")
@Data
@CrossOrigin
public class BilkentCourse extends Course{
    private int bilkentCourseCredit;
    @OneToOne
    private Instructor instructor;
    @OneToMany
    private Set<Course> matchedCourse;

    public int getBilkentCourseCredit() {
        return bilkentCourseCredit;
    }

    public void setBilkentCourseCredit(int bilkentCourseCredit) {
        this.bilkentCourseCredit = bilkentCourseCredit;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Set<Course> getMatchedCourse() {
        return matchedCourse;
    }

    public void setMatchedCourse(Set<Course> matchedCourse) {
        this.matchedCourse = matchedCourse;
    }
}
