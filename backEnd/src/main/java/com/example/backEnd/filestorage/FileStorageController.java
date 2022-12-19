package com.example.backEnd.filestorage;

import com.example.backEnd.application.Application;
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

import javax.swing.*;
import java.awt.*;
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
    private final FileStorageRepository fileStorageRepository;
    @Autowired
    public FileStorageController(FileStorageService fileStorageService, FileStorageRepository fileStorageRepository) {
        this.fileStorageService = fileStorageService;
        this.fileStorageRepository = fileStorageRepository;
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
        return fileStorageService.findFromDocumentID(documentID);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSignedFrance/{documentID}/{documentID2}")
    @ResponseBody
    public String getSignedFileForFrance(@PathVariable long documentID,@PathVariable long documentID2
                                           ) throws IOException {
        FileStorage uploadResponse = fileStorageService.findFromDocumentID(documentID);
        FileStorage uploadResponse2 = fileStorageService.findFromDocumentID(documentID2);

        /*
        String fileName = fileStorageService.storeFile(file);
        FileStorage uploadResponse = new FileStorage(fileName, userID, documentID);//pdf
        String fileName2 = fileStorageService.storeFile(file2);
        FileStorage uploadResponse2 = new FileStorage(fileName2, userID, documentID2); //png
        */


        fileStorageService.signFileForFrance(uploadResponse, uploadResponse2);

        /*

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        String filename = fileStorageService.getFilePath(documentID);
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filename));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

         */
        return "done";
        }

    @RequestMapping(method = RequestMethod.GET, value = "/getSignedNetherlands/{documentID}/{documentID2}")
    @ResponseBody
    public String getSignedFileForNetherlands(@PathVariable long documentID,@PathVariable long documentID2
    ) throws IOException {
        FileStorage uploadResponse = fileStorageService.findFromDocumentID(documentID);
        FileStorage uploadResponse2 = fileStorageService.findFromDocumentID(documentID2);

        fileStorageService.signFileForNetherlands(uploadResponse, uploadResponse2);
        return "done";
    }
    /*
    @RequestMapping(method = RequestMethod.GET, value = "/getSignedCTE/{documentID}/{documentID2}")
    @ResponseBody
    public String getSignedFileForCTE(@PathVariable long documentID,@PathVariable long documentID2
    ) throws IOException {
        FileStorage uploadResponse = fileStorageService.findFromDocumentID(documentID);
        FileStorage uploadResponse2 = fileStorageService.findFromDocumentID(documentID2);

        fileStorageService.signFileForCTECoordinator(uploadResponse, uploadResponse2);
        fileStorageService.signFileForCTEChair(uploadResponse, uploadResponse2);
        fileStorageService.signFileForCTEDean(uploadResponse, uploadResponse2);

        return "done";
    }

     */

    @RequestMapping(method = RequestMethod.GET, value = "/getSignCoordinatorCTE/{documentID}/{documentID2}")
    @ResponseBody
    public String getSignedFileCoordinatorForCoorCTE(@PathVariable long documentID,@PathVariable long documentID2
    ) throws IOException {
        FileStorage uploadResponse = fileStorageService.findFromDocumentID(documentID);
        FileStorage uploadResponse2 = fileStorageService.findFromDocumentID(documentID2);

        fileStorageService.signFileForCTECoordinator(uploadResponse, uploadResponse2);

        return "done";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getSignChairCTE/{documentID}/{documentID2}")
    @ResponseBody
    public String getSignedFileChairForCTE(@PathVariable long documentID,@PathVariable long documentID2
    ) throws IOException {
        FileStorage uploadResponse = fileStorageService.findFromDocumentID(documentID);
        FileStorage uploadResponse2 = fileStorageService.findFromDocumentID(documentID2);

        fileStorageService.signFileForCTEChair(uploadResponse, uploadResponse2);

        return "done";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getSignDeamCTE/{documentID}/{documentID2}")
    @ResponseBody
    public String getSignedFileDeanForCTE(@PathVariable long documentID,@PathVariable long documentID2
    ) throws IOException {
        FileStorage uploadResponse = fileStorageService.findFromDocumentID(documentID);
        FileStorage uploadResponse2 = fileStorageService.findFromDocumentID(documentID2);

        fileStorageService.signFileForCTEDean(uploadResponse, uploadResponse2);

        return "done";
    }

}
