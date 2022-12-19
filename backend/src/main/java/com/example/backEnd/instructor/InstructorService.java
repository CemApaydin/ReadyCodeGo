package com.example.backEnd.instructor;

import java.util.List;

public interface InstructorService {
    public Instructor saveInstructor(Instructor instructor);
    public List<Instructor> getAllInstructors();
    public Instructor findById( Long userId);
}
