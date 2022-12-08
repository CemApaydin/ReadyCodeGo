package com.example.backEnd.service;

import com.example.backEnd.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student findById( Long userId);
}
