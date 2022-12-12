package com.example.backEnd.application;

import com.example.backEnd.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/findAll")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    @PostMapping("/createApplication")
    public Application createApplication(@RequestBody Application newApplication){
        return applicationService.saveApplication(newApplication);
    }

    @GetMapping("/{applicationId}")
    public Application getOneApplication(@PathVariable Long applicationId){
        return applicationService.findById(applicationId);
    }

    @GetMapping("/application/{applicationId}")
    public Application getOneApplicationA(@PathVariable Long applicationId)
    {
        return applicationService.findById(applicationId);
    }

}