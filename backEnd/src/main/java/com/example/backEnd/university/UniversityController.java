package com.example.backEnd.university;

import com.example.backEnd.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/university")
public class UniversityController {
    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/findAll")
    public List<University> getAllUniversities()
    {
        return universityService.getAllUniversities();
    }

    @PostMapping("/createUniversity")
    public String createUniversity(@RequestBody University newUniversity)
    {
        universityService.saveUniversity(newUniversity);
        return "Adding Done!!";
    }

    @GetMapping("/{universityId}")
    public University getOneUniversity(@PathVariable Long universityId)
    {
        return universityService.findById(universityId);
    }
    @GetMapping("/university/{universityId}")
    public University getOneUniversityA(@PathVariable Long universityId)
    {
        return universityService.findById(universityId);
    }

}
