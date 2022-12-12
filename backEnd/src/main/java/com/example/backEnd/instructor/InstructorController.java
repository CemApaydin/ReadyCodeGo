package com.example.backEnd.instructor;

import com.example.backEnd.student.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/findAll")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping("/createInstructor")
    public String createInstructor(@RequestBody Instructor newInstructor){
        instructorService.saveInstructor(newInstructor);
        return "Adding Done!!";
    }

    @GetMapping("/{userId}")
    public Instructor getOneInstructor(@PathVariable Long userId)
    {
        return instructorService.findById(userId);
    }
    @GetMapping("/student/{userId}")
    public Instructor getOneInstructorA(@PathVariable Long userId)
    {
        return instructorService.findById(userId);
    }

}
