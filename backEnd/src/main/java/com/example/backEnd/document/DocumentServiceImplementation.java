package com.example.backEnd.document;
import com.example.backEnd.application.*;
import com.example.backEnd.student.*;
import com.example.backEnd.user.User;



import com.example.backEnd.instructor.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImplementation implements DocumentService {
    private final DocumentRepository documentRepository;
    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;


    public DocumentServiceImplementation(DocumentRepository documentRepository, ApplicationRepository applicationRepository, StudentRepository studentRepository) {
        this.documentRepository = documentRepository;
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Document saveDocument(Document document) {
        Application application = applicationRepository.findById(document.getApplicationID()).orElse(null);
        Student uploader = studentRepository.findById(document.getUploaderId()).orElse(null);
        Application application2 = uploader.getApplication();
        long num = application2.getApplicationID();
        long num2 = application.getApplicationID();

        //if(application == null || uploader == null) {
        if(uploader == null ){
            return null;
        }
        if(num != num2 ){
            return null;
        }

        application.addTodocumentIds(document.getDocumentId());
        applicationRepository.save(application);
        applicationRepository.save(application2);
        studentRepository.save(uploader);

        return documentRepository.save(document);

    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(Long documentId) {
        return documentRepository.findById(documentId).orElse(null);
    }
}
