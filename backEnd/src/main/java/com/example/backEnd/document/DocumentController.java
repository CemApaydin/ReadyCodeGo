package com.example.backEnd.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/document")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/findAll")
    public List<Document> getAllDocuments()
    {
        return documentService.getAllDocuments();
    }

    @PostMapping("/createDocument")
    public String createDocument(@RequestBody Document newDocument)
    {
        documentService.saveDocument(newDocument);
        return "Adding Done!!";
    }
    @GetMapping("/{documentID}")
    public Document getOneDocument(@PathVariable Long documentID)
    {
        return documentService.findById(documentID);
    }
    @GetMapping("/document/{documentID}")
    public Document getOneDocumentA(@PathVariable Long documentID)
    {
        return documentService.findById(documentID);
    }

}

