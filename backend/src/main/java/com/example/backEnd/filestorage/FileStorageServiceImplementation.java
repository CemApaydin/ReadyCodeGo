package com.example.backEnd.filestorage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import com.example.backEnd.signature.*;
import com.example.backEnd.signature.SignRepository;
import com.example.backEnd.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageServiceImplementation implements FileStorageService{

    private final Path fileStorageLocation;
    private final FileStorageRepository fileStorageRepository;
    private final UserRepository userRepository;
    private final SignRepository signRepository;
    @Autowired
    public FileStorageServiceImplementation(Environment env, FileStorageRepository fileStorageRepository, UserRepository userRepository, SignRepository signRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.userRepository = userRepository;
        this.signRepository = signRepository;
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
        FileStorage fileStorage = findFromDocumentID(documentID);
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
    public String signFileForFrance(FileStorage fileStorage, FileStorage fileStorage2) throws IOException {

        Sign sign = new Sign(fileStorage.getDocumentID());
        String fileName = fileStorage.getFileName();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        String a = targetLocation.toString();
        //String[] lines = a.split("\\.");
        String name = "";

        int lastDotIndex = a.lastIndexOf('.');
        name = a.substring(0, lastDotIndex ) + "-1" + a.substring(lastDotIndex);
        //String file = FilenameUtils.getBaseName(name);
        String file = FilenameUtils.getName(name);


        sign.setFile(a);

        sign.setDoc(sign.getFile());
        sign.setPage(1);

        String fileName2 = fileStorage2.getFileName();
        Path targetLocation2 = this.fileStorageLocation.resolve(fileName2);
        String b = targetLocation2.toString();
        sign.setPdImage(b, sign.getDoc());
      //  ImageIcon icon = new ImageIcon(b);
       // Image scaleImage = icon.getImage().getScaledInstance(28, 28,Image.SCALE_DEFAULT);
       // BufferedImage image = ImageIO.read(new File(b));

        sign.setContents(sign.getDoc(), sign.getPage());

        sign.getContents().drawImage(sign.getPdImage(), 500, 330, 140,40); //bakarsın

        sign.getContents().close();
        //sign.getDoc().save("/Users/goksusenerkek/Desktop/ReadyCodeGo/uploads/files/2010-1.pdf");
        System.out.println(name);
        sign.getDoc().save(name);

        //sign.getDoc().save(a);
        sign.getDoc().close();

        fileStorage.setFileName(file);
        fileStorageRepository.save(fileStorage);

        return "Sign Succesfully added to PDF";
    }
    @Override
    public String signFileForNetherlands(FileStorage fileStorage, FileStorage fileStorage2) throws IOException {

        Sign sign = new Sign(fileStorage.getDocumentID());
        String fileName = fileStorage.getFileName();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        String a = targetLocation.toString();
        String name = "";

        int lastDotIndex = a.lastIndexOf('.');
        name = a.substring(0, lastDotIndex ) + "-1" + a.substring(lastDotIndex);
        String file = FilenameUtils.getName(name);

        sign.setFile(a);

        sign.setDoc(sign.getFile());
        sign.setPage(0);

        String fileName2 = fileStorage2.getFileName();
        Path targetLocation2 = this.fileStorageLocation.resolve(fileName2);
        String b = targetLocation2.toString();
        sign.setPdImage(b, sign.getDoc());

        sign.setContents(sign.getDoc(), sign.getPage());

        sign.getContents().drawImage(sign.getPdImage(), 489, 130, 140,40); //bakarsın

        sign.getContents().close();
        System.out.println(name);
        sign.getDoc().save(name);

        sign.getDoc().close();

        fileStorage.setFileName(file);
        fileStorageRepository.save(fileStorage);

        return "Sign Succesfully added to PDF";
    }

    @Override
    public String signFileForCTECoordinator(FileStorage fileStorage, FileStorage fileStorage2) throws IOException {

        Sign sign = new Sign(fileStorage.getDocumentID());
        String fileName = fileStorage.getFileName();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        String a = targetLocation.toString();
        String name = "";

        int lastDotIndex = a.lastIndexOf('.');
        name = a.substring(0, lastDotIndex ) + "-1" + a.substring(lastDotIndex);
        String file = FilenameUtils.getName(name);

        sign.setFile(a);

        sign.setDoc(sign.getFile());
        sign.setPage(0);

        String fileName2 = fileStorage2.getFileName();
        Path targetLocation2 = this.fileStorageLocation.resolve(fileName2);
        String b = targetLocation2.toString();
        sign.setPdImage(b, sign.getDoc());

        sign.setContents(sign.getDoc(), sign.getPage());

        sign.getContents().drawImage(sign.getPdImage(), 535, 140, 120,18); //bakarsın

        sign.getContents().close();
        System.out.println(name);
        sign.getDoc().save(name);

        sign.getDoc().close();

        fileStorage.setFileName(file);
        fileStorageRepository.save(fileStorage);

        return "Sign Succesfully added to PDF";
    }

    @Override
    public String signFileForCTEDean(FileStorage fileStorage, FileStorage fileStorage2) throws IOException {

        Sign sign = new Sign(fileStorage.getDocumentID());
        String fileName = fileStorage.getFileName();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        String a = targetLocation.toString();
        String name = "";

        int lastDotIndex = a.lastIndexOf('.');
        int lastDotIndex2 = a.lastIndexOf('-');

        name = a.substring(0, lastDotIndex2 ) + "-signed" + a.substring(lastDotIndex);
        String file = FilenameUtils.getName(name);

        sign.setFile(a);

        sign.setDoc(sign.getFile());
        sign.setPage(0);

        String fileName2 = fileStorage2.getFileName();
        Path targetLocation2 = this.fileStorageLocation.resolve(fileName2);
        String b = targetLocation2.toString();
        sign.setPdImage(b, sign.getDoc());

        sign.setContents(sign.getDoc(), sign.getPage());

        sign.getContents().drawImage(sign.getPdImage(), 535, 113, 120,18); //bakarsın

        sign.getContents().close();
        System.out.println(name);
        sign.getDoc().save(name);

        sign.getDoc().close();

        fileStorage.setFileName(file);
        fileStorageRepository.save(fileStorage);

        return "Sign Succesfully added to PDF";
    }

    @Override
    public String signFileForCTEChair(FileStorage fileStorage, FileStorage fileStorage2) throws IOException {

        Sign sign = new Sign(fileStorage.getDocumentID());
        String fileName = fileStorage.getFileName();
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        String a = targetLocation.toString();
        String name = "";

        int lastDotIndex = a.lastIndexOf('.');
        int lastDotIndex2 = a.lastIndexOf('-');

        name = a.substring(0, lastDotIndex2 ) + "-2" + a.substring(lastDotIndex);
        String file = FilenameUtils.getName(name);

        sign.setFile(a);

        sign.setDoc(sign.getFile());
        sign.setPage(0);

        String fileName2 = fileStorage2.getFileName();
        Path targetLocation2 = this.fileStorageLocation.resolve(fileName2);
        String b = targetLocation2.toString();
        sign.setPdImage(b, sign.getDoc());

        sign.setContents(sign.getDoc(), sign.getPage());

        sign.getContents().drawImage(sign.getPdImage(), 535, 128, 120,18); //bakarsın

        sign.getContents().close();
        System.out.println(name);
        sign.getDoc().save(name);

        sign.getDoc().close();

        fileStorage.setFileName(file);
        fileStorageRepository.save(fileStorage);

        return "Sign Succesfully added to PDF";
    }
    @Override
    public FileStorage findById(Long documentId) {
        return fileStorageRepository.findById(documentId).orElse(null);
    }
    public FileStorage findFromDocumentID(long documentID) {
        return fileStorageRepository.findFromDocumentID(documentID);

    }



}