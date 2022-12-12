package com.example.backEnd.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImplementation implements  InstructorService{

    private final InstructorRepository instructorRepository;

    @Autowired

    public InstructorServiceImplementation(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(Long userId) {
        return instructorRepository.findById(userId).orElse(null);
    }
}
