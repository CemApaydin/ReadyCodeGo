package com.example.backEnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="transcript")
@Data
@CrossOrigin
public class Transcript extends Document{
    @OneToMany
    private Set<Course> courseList;
    private int totalCredit;
    @OneToOne
    private University hostUniversity;

    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public University getHostUniversity() {
        return hostUniversity;
    }

    public void setHostUniversity(University hostUniversity) {
        this.hostUniversity = hostUniversity;
    }
}
