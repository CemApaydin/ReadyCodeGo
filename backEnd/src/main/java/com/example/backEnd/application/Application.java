package com.example.backEnd.application;

import com.example.backEnd.document.Document;
import com.example.backEnd.university.University;
import com.example.backEnd.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="application")
@Data
@CrossOrigin
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationID;
    private String applicationStatus;
    @OneToMany
    private Set<University> appliedUniversities;
    @OneToOne
    private Student student;
    @OneToMany
    private Set<Document> documents;

    public Application() {
    }

    public Application(Long applicationID,
                       String applicationStatus,
                       Set<University> appliedUniversities,
                       Student student,
                       Set<Document> documents) {
        this.applicationID = applicationID;
        this.applicationStatus = applicationStatus;
        this.appliedUniversities = appliedUniversities;
        this.student = student;
        this.documents = documents;
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Set<University> getAppliedUniversities() {
        return appliedUniversities;
    }

    public void setAppliedUniversities(Set<University> appliedUniversities) {
        this.appliedUniversities = appliedUniversities;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
