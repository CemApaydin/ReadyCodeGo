package com.example.backEnd.filestorage;

import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    public String getFileExtension(String fileName);
    public String getFileName(String fileName) ;

    public String storeFile(MultipartFile file);

    public FileStorage saveFileStorage(FileStorage fileStorage);
}
