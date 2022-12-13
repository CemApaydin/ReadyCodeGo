package com.example.backEnd.document;

import java.util.List;

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
