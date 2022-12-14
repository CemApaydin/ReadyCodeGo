package com.example.backEnd.transcript;

import com.example.backEnd.application.*;
import com.example.backEnd.student.*;
import com.example.backEnd.document.*;

import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class TranscriptServiceImplementation implements TranscriptService {
    private final TranscriptRepository transcriptRepository;
    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;
    private final DocumentRepository documentRepository;

    public TranscriptServiceImplementation(TranscriptRepository transcriptRepository, ApplicationRepository applicationRepository, StudentRepository studentRepository, DocumentRepository documentRepository) {
        this.transcriptRepository = transcriptRepository;
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public Transcript saveTranscript(Transcript transcript) {
        Application application = applicationRepository.findById(transcript.getApplicationID()).orElse(null);


        Document document = transcript;
        if(document.getDocumentId() != transcript.getDocumentId()) {
            return null;
        }
        application.addTodocumentIds(document.getDocumentId());

        documentRepository.save(document);
        return transcriptRepository.save(transcript);

    }

    @Override
    public List<Transcript> getAllTranscripts() {
        return transcriptRepository.findAll();
    }

    @Override
    public Transcript findById(Long documentId) {
        return transcriptRepository.findById(documentId).orElse(null);
    }
}
