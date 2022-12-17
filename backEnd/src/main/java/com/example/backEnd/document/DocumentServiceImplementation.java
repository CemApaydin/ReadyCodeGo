package com.example.backEnd.document;

import com.example.backEnd.attachment.AttachmentComponent;

import com.example.backEnd.attachment.AttachmentComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImplementation implements DocumentService {
    private final DocumentRepository documentRepository;
    private final AttachmentComponentRepository attachmentComponentRepository;

    public DocumentServiceImplementation(DocumentRepository documentRepository, AttachmentComponentRepository attachmentComponentRepository) {
        this.documentRepository = documentRepository;
        this.attachmentComponentRepository = attachmentComponentRepository;
    }

    @Override
    public Document saveDocument(Document document) {
        AttachmentComponent attachmentComponent = document;
        attachmentComponentRepository.save(attachmentComponent);
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
