package com.example.backEnd.bilkentCourse;

import com.example.backEnd.course.Course;
import com.example.backEnd.instructor.Instructor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="bilkentcourse")
@Data
@CrossOrigin
public class BilkentCourse extends Course {
    private int bilkentCourseCredit;
    private Long instructorId;
    @ElementCollection
    private Set<Long> matchedCourseIds;

    public BilkentCourse(String courseID, String courseName, double ECTS, int bilkentCourseCredit, Long instructorId, Set<Long> matchedCourseIds) {
        super(courseID, courseName, ECTS);
        this.bilkentCourseCredit = bilkentCourseCredit;
        this.instructorId = instructorId;
        this.matchedCourseIds = matchedCourseIds;
    }

    public BilkentCourse(String courseID, String courseName, double ECTS) {
        super(courseID, courseName, ECTS);
        bilkentCourseCredit = 0;
        instructorId = null;
        matchedCourseIds = null;
    }

    public BilkentCourse() {
        super();
    }

    public int getBilkentCourseCredit() {
        return bilkentCourseCredit;
    }

    public void setBilkentCourseCredit(int bilkentCourseCredit) {
        this.bilkentCourseCredit = bilkentCourseCredit;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Set<Long> getMatchedCourseIds() {
        return matchedCourseIds;
    }

    public void setMatchedCourseIds(Set<Long> matchedCourseIds) {
        this.matchedCourseIds = matchedCourseIds;
    }
}
