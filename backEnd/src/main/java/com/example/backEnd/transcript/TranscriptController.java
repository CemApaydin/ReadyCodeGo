package com.example.backEnd.transcript;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/transcript")
public class TranscriptController {
    private final TranscriptService transcriptService;

    @Autowired
    public TranscriptController(TranscriptService transcriptService) {
        this.transcriptService = transcriptService;
    }

    @GetMapping("/findAll")
    public List<Transcript> getAllTranscripts()
    {
        return transcriptService.getAllTranscripts();
    }

    @PostMapping("/createTranscript")
    public String createTranscript(@RequestBody Transcript newTranscript)
    {
        if( transcriptService.saveTranscript(newTranscript) == null) {
            return "Not Correct!";
        }
        transcriptService.saveTranscript(newTranscript);
        return "Adding Done!!";
    }

    @PostMapping("/addCourse/{transcriptId}")
    public Transcript addCourse(@PathVariable Long transcriptId, @RequestBody String courseId){
        return transcriptService.addCourse(transcriptService.findById(transcriptId),courseId);
    }

    @PostMapping("/deleteCourse/{transcriptId}")
    public Transcript deleteCourse(@PathVariable Long transcriptId, @RequestBody String courseId){
        return transcriptService.deleteCourse(transcriptService.findById(transcriptId),courseId);
    }

    @GetMapping("/{transcriptID}")
    public Transcript getOneTranscript(@PathVariable Long transcriptID)
    {
        return transcriptService.findById(transcriptID);
    }
    @GetMapping("/transcript/{transcriptID}")
    public Transcript getOneTranscriptA(@PathVariable Long transcriptID)
    {
        return transcriptService.findById(transcriptID);
    }

}
