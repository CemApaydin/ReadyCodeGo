package com.example.backEnd.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.io.File;
import java.io.IOException;


@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    
    @Value ("C:/Users/Lenovo/Documents/GitHub/ReadyCodeGo/backEnd/src/main/resources/universityList.xlsx")
    Resource resourceFile;
    
    @Autowired 
    ResourceLoader resourceLoader;
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
    @PatchMapping("/student")
    public String readFromExcel() throws IOException {
        resourceFile = resourceLoader.getResource("classpath:ErasmusList.xlsx");
        if(resourceFile.exists()) {  
            InputStream var = new FileInputStream(resourceFile.getFile());
            if(var != null) {
                System.out.println("var is not null");
                studentService.excelToStudentList(var); 
                return "Done"; 
            }
        }
        return "file is not exist";
    }
}
