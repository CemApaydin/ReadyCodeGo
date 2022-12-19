package com.example.backEnd.transcript;

import java.util.List;

public interface TranscriptService {
    public Transcript saveTranscript(Transcript transcript);
    public Transcript addCourse(Transcript transcript, String courseId);
    public Transcript deleteCourse(Transcript transcript, String courseId);
    public List<Transcript> getAllTranscripts();
    public Transcript findById(Long documentId);
}
