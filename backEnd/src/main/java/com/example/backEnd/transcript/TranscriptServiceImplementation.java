package com.example.backEnd.transcript;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranscriptServiceImplementation implements TranscriptService {
    private final TranscriptRepository transcriptRepository;

    public TranscriptServiceImplementation(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript saveTranscript(Transcript transcript) {
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
