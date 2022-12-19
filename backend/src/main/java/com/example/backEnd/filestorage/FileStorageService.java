package com.example.backEnd.filestorage;

import com.example.backEnd.document.Document;
import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileStorageService {
    public String getFileExtension(String fileName);
    public String getFileName(String fileName) ;

    public String storeFile(MultipartFile file);

    public FileStorage saveFileStorage(FileStorage fileStorage);
    public FileStorage findById(Long documentID);
    public FileStorage findFromDocumentID(long documentID);
    public String getFilePath(long documentID);
    public String signFileForFrance(FileStorage fileStorage, FileStorage fileStorage2) throws IOException;
    public String signFileForNetherlands(FileStorage fileStorage, FileStorage fileStorage2) throws IOException;

    public String signFileForCTECoordinator(FileStorage fileStorage, FileStorage fileStorage2) throws IOException;

    public String signFileForCTEChair(FileStorage fileStorage, FileStorage fileStorage2) throws IOException;
    public String signFileForCTEDean(FileStorage fileStorage, FileStorage fileStorage2) throws IOException;



}
