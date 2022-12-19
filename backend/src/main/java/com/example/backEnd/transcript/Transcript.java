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

    public Transcript(String uploadDate, Long uploaderId, Set<String> courseIdsList, int totalCredit, Long hostUniversityId) {
        super(uploadDate, uploaderId);
        this.courseIdsList = courseIdsList;
        this.totalCredit = totalCredit;
        this.hostUniversityId = hostUniversityId;
    }
    public Transcript(String uploadDate, Long uploaderId, int totalCredit, Long hostUniversityId) {
        super(uploadDate, uploaderId);
        this.courseIdsList = null;
        this.totalCredit = totalCredit;
        this.hostUniversityId = hostUniversityId;
    }

    public Transcript(String uploadDate, Long uploaderId) {
        super(uploadDate, uploaderId);
        this.courseIdsList = null;
        this.hostUniversityId = null;
    }

    public Transcript() {
        super();
    }

    @Override
    public Long getAttachmentId() {
        return super.getAttachmentId();
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
