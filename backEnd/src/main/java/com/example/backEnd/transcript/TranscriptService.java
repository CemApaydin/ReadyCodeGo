package com.example.backEnd.transcript;

import java.util.List;

public interface TranscriptService {
    public Transcript saveTranscript(Transcript transcript);
    public List<Transcript> getAllTranscripts();
    public Transcript findById(Long documentId);
}
