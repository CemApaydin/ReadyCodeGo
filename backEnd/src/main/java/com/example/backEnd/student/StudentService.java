package com.example.backEnd.student;

import java.io.InputStream;
import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student findById( Long userId);
    public void excelToStudentList(InputStream is);
}
