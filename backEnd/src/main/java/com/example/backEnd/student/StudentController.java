package com.example.backEnd.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private ApplicationContext excel;
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
    @GetMapping("/appId/{userId}")
    public Long getOneStudentA(@PathVariable Long userId)
    {
        return studentService.findById(userId).getApplication().getApplicationID();
    }
    @PatchMapping("/student")
    public String readFromExcel() {
        InputStream var = (InputStream) excel.getResource("classpath:universityList.xlsx");
        studentService.excelToStudentList(var);  
        return "Done";  
    }


}
