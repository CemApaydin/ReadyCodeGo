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
    @ManyToOne
    private User uploader;

    public Document() {
    }

    public Document(Long documentId, String uploadDate, User uploader) {
        this.documentId = documentId;
        this.uploadDate = uploadDate;
        this.uploader = uploader;
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

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }
}
