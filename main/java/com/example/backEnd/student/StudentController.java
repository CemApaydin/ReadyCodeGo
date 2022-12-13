package com.example.backEnd.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController( StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestBody Student newStudent)
    {

        studentService.saveStudent(newStudent);
        return "Adding Done!!";
    }
    @GetMapping("/{userId}")
    public Student getOneStudent(@PathVariable Long userId)
    {
        return studentService.findById(userId);
    }
    @GetMapping("/student/{userId}")
    public Student getOneStudentA(@PathVariable Long userId)
    {
        return studentService.findById(userId);
    }


}
