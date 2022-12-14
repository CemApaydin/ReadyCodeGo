package com.example.backEnd.document;

import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "document")
@Data
@CrossOrigin
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String uploadDate;
    private Long uploaderId;
    private Long applicationId;
    public Document( String uploadDate, Long uploaderId, Long applicationId) {
        this.uploadDate = uploadDate;
        this.uploaderId = uploaderId;
        this.applicationId = applicationId;
    }

    public Document() {
        this.uploadDate = null;
        this.uploaderId = null;
        this.applicationId = null;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public Long getApplicationID() {
        return applicationId;
    }
}
