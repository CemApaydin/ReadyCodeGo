package com.example.backEnd.filestorage;

import com.example.backEnd.document.Document;
import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileStorageService {
    public String getFileExtension(String fileName);
    public String getFileName(String fileName) ;

    public String storeFile(MultipartFile file);

    public FileStorage saveFileStorage(FileStorage fileStorage);
    public FileStorage findById(Long documentID);
    public String getFilePath(long documentID);


    }
