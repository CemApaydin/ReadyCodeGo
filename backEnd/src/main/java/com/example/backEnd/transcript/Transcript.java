package com.example.backEnd.transcript;

import com.example.backEnd.course.Course;
import com.example.backEnd.document.Document;
import com.example.backEnd.university.University;
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
public class Transcript extends Document {
    @OneToMany
    private Set<Course> courseList;
    private int totalCredit;
    @OneToOne
    private University hostUniversity;

    public Transcript(Set<Course> courseList, int totalCredit, University hostUniversity) {
        this.courseList = courseList;
        this.totalCredit = totalCredit;
        this.hostUniversity = hostUniversity;
    }

    public Transcript() {
    }

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
