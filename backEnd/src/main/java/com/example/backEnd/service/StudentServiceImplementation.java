package com.example.backEnd.service;

import com.example.backEnd.entity.Student;
import com.example.backEnd.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student findById(Long userId) {
        return studentRepository.findById(userId).orElse(null);
    }
}
