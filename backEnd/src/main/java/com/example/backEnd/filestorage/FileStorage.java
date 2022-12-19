package com.example.backEnd.filestorage;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
@Table(name="filestorage")
@Entity
@Data
@CrossOrigin
public class FileStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    private long userID;
    private long documentID;

    private String uploadDate;

    public FileStorage(String fileName, long userID, long documentID) {
        this.fileName = fileName;
        this.userID = userID;
        this.documentID = documentID;
        this.uploadDate = null;
    }

    public FileStorage() {
        fileName = null;
        userID = 0;
        documentID = 0;
        uploadDate = null;
    }

    public String getDateOfBirth() {
        return uploadDate;
    }

    public String getFileName() {
        return fileName;
    }

    public long getUserID() {
        return userID;
    }
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
}