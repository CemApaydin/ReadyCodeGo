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

    public DocumentServiceImplementation(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document saveDocument(Document document) {
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
