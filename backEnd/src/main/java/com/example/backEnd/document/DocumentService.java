package com.example.backEnd.document;

import java.util.List;

public interface DocumentService {
    public Document saveDocument(Document document);
    public List<Document> getAllDocuments();
    public Document findById(Long documentId);
}