package com.example.backEnd.filestorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;

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

    @RequestMapping(method = RequestMethod.GET, value = "/getFileDirectly/{documentID:.+}", produces= {"application/pdf"})
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable long documentID) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        String filename = fileStorageService.getFilePath(documentID);
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filename));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getFile/{documentID}")
    public FileStorage getFileStorageA(@PathVariable Long documentID){
        return fileStorageService.findById(documentID);
    }

}
