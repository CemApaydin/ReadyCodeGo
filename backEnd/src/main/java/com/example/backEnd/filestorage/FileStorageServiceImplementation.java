package com.example.backEnd.filestorage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.backEnd.document.Document;
import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import com.example.backEnd.student.Student;
import com.example.backEnd.user.*;
import com.example.backEnd.facultyboardmember.FacultyBoardMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileStorageServiceImplementation implements FileStorageService{

    private final Path fileStorageLocation;
    private final FileStorageRepository fileStorageRepository;
    private final UserRepository userRepository;
    @Autowired
    public FileStorageServiceImplementation(Environment env, FileStorageRepository fileStorageRepository, UserRepository userRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.userRepository = userRepository;
        this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-dir", "./uploads/files"))
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException(
                    "Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        String[] fileNameParts = fileName.split("\\.");

        return fileNameParts[fileNameParts.length - 1];
    }
    public String getFileName(String fileName) {
        String name = "";
        if (fileName == null) {
            return null;
        }

        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            name = fileName.substring(index -1);
        }
        return name;

    }


    public String getFilePath(long documentID) {
        FileStorage fileStorage = findById(documentID);
        String fileName = fileStorage.getFileName();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        String a = targetLocation.toString();
        return a;

    }
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName =
                //new Date().getTime() + "-file." + getFileExtension(file.getOriginalFilename());
            file.getOriginalFilename();
        try {
            // Check if the filename contains invalid characters
            if (fileName.contains("..")) {
                throw new RuntimeException(
                        "Sorry! Filename contains invalid path sequence " + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    @Override
    public FileStorage saveFileStorage(FileStorage fileStorage) {
        User uploader = userRepository.findById(fileStorage.getUserID()).orElse(null);
        if(uploader == null ){
            return null;
        }
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        fileStorage.setUploadDate(date);
        return fileStorageRepository.save(fileStorage);

    }


    @Override
    public FileStorage findById(Long documentId) {
        return fileStorageRepository.findById(documentId).orElse(null);
    }
}