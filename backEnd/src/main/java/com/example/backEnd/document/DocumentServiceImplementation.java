package com.example.backEnd.document;
import com.example.backEnd.application.*;
import com.example.backEnd.student.*;
import com.example.backEnd.task.*;
import com.example.backEnd.task.TaskRepository;
import com.example.backEnd.user.*;



import com.example.backEnd.instructor.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImplementation implements DocumentService {
    private final DocumentRepository documentRepository;
    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public DocumentServiceImplementation(DocumentRepository documentRepository, ApplicationRepository applicationRepository, StudentRepository studentRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Document saveDocumentsToApplication(Document document) {
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
    public Document saveDocumentsToTask(Document document) {
        /*
        Task task = taskRepository.findById(document.getApplicationID()).orElse(null);
        Task task2 = taskRepository.findById(document.getApplicationID()).orElse(null);
        User uploader = studentRepository.findById(document.getUploaderId()).orElse(null);
        User receiver = studentRepository.findById(document.getReceiverId()).orElse(null);


        //if(application == null || uploader == null) {
        if(uploader == null ){
            return null;
        }
        if(num != num2 ){
            return null;
        }

        task1.addToSenderDocumentIds(document.getDocumentId());
        task2.addToReceiverDocumentIds(document.getDocumentId());

        studentRepository.save(uploader);

        return documentRepository.save(document);
*/
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
