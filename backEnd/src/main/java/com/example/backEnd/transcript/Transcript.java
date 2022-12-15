package com.example.backEnd.transcript;

import com.example.backEnd.course.Course;
import com.example.backEnd.document.Document;
import com.example.backEnd.university.University;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="transcript")
@Data
@CrossOrigin
public class Transcript extends Document {
    @ElementCollection
    private Set<String> courseIdsList;
    private int totalCredit;
    private Long hostUniversityId;

    public Transcript(String uploadDate, Long uploaderId, Long applicationId, Set<String> courseIdsList, int totalCredit, Long hostUniversityId) {
        super(uploadDate, uploaderId, applicationId);
        this.courseIdsList = courseIdsList;
        this.totalCredit = totalCredit;
        this.hostUniversityId = hostUniversityId;
    }
    public Transcript(String uploadDate, Long uploaderId, Long applicationId, int totalCredit, Long hostUniversityId) {
        super(uploadDate, uploaderId, applicationId);
        this.courseIdsList = null;
        this.totalCredit = totalCredit;
        this.hostUniversityId = hostUniversityId;
    }

    public Transcript(String uploadDate, Long uploaderId, Long applicationId) {
        super(uploadDate, uploaderId, applicationId);
        this.courseIdsList = null;
        this.hostUniversityId = null;
    }

    public Transcript() {
        super();
    }

    public Set<String> getCourseIdsList() {
        return courseIdsList;
    }

    public void setCourseIdsList(Set<String> courseIdsList) {
        this.courseIdsList = courseIdsList;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Long getHostUniversityId() {
        return hostUniversityId;
    }

    public void setHostUniversityId(Long hostUniversityId) {
        this.hostUniversityId = hostUniversityId;
    }
    public void addToCourseIdsList(String courseID) {
        courseIdsList.add(courseID);
    }
}
