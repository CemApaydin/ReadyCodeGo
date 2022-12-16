package com.example.backEnd.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController

@CrossOrigin
@RequestMapping("/filestorage")
public class FileStorageController {

    private final FileStorageService fileStorageService;

    @Autowired
    public FileStorageController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileStorage> uploadFile(
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam("userID") long userID,
            @RequestParam("documentID") long documentID
    ) {
        String fileName = fileStorageService.storeFile(file);
        FileStorage uploadResponse = new FileStorage(fileName, userID, documentID);
        fileStorageService.saveFileStorage(uploadResponse);
        return ResponseEntity.ok().body(uploadResponse);
    }
}
