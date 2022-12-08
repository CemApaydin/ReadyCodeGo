package com.example.backEnd.controller;

import com.example.backEnd.entity.Student;
import com.example.backEnd.repo.StudentRepository;
import com.example.backEnd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    public StudentController( StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
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
