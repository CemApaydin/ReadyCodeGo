package com.example.backEnd.transcript;

import com.example.backEnd.application.*;
import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.attachment.AttachmentComponentRepository;
import com.example.backEnd.student.*;
import com.example.backEnd.document.*;

import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class TranscriptServiceImplementation implements TranscriptService {
    private final TranscriptRepository transcriptRepository;
    private final AttachmentComponentRepository attachmentComponentRepository;

    public TranscriptServiceImplementation(TranscriptRepository transcriptRepository, AttachmentComponentRepository attachmentComponentRepository) {
        this.transcriptRepository = transcriptRepository;
        this.attachmentComponentRepository = attachmentComponentRepository;
    }

    @Override
    public Transcript saveTranscript(Transcript transcript) {
        AttachmentComponent attachmentComponent = transcript;
        if(attachmentComponent.getAttachmentId() != transcript.getAttachmentId()) {
            return null;
        }
        attachmentComponentRepository.save(attachmentComponent);
        return transcriptRepository.save(transcript);

    }

    @Override
    public Transcript addCourse(Transcript transcript, String courseId) {
        transcript.getCourseIdsList().add(courseId);
        return transcriptRepository.save(transcript);
    }

    @Override
    public Transcript deleteCourse(Transcript transcript, String courseId){
        transcript.getCourseIdsList().remove(courseId);
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
