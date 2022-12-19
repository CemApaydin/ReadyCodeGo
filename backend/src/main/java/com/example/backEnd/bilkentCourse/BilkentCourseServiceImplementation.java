package com.example.backEnd.bilkentCourse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.backEnd.instructor.*;
import com.example.backEnd.course.*;

@Service
public class BilkentCourseServiceImplementation implements BilkentCourseService {
    private final BilkentCourseRepository bilkentCourseRepository;
    private final InstructorRepository instructorRepository;

    public BilkentCourseServiceImplementation(BilkentCourseRepository bilkentCourseRepository, InstructorRepository instructorRepository) {
        this.bilkentCourseRepository = bilkentCourseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public BilkentCourse saveBilkentCourse(BilkentCourse bilkentCourse) {
        Instructor instructor = instructorRepository.findById(bilkentCourse.getInstructorId()).orElse(null);
        if(instructor == null) {
            return null;
        }

        instructor.addToRelatedCourseIds(bilkentCourse.getCourseID());
        return bilkentCourseRepository.save(bilkentCourse);
    }

    @Override
    public List<BilkentCourse> getAllBilkentCourses() {
        return bilkentCourseRepository.findAll();
    }

    @Override
    public BilkentCourse findById(String courseId) {
        return bilkentCourseRepository.findById(courseId).orElse(null);
    }
}
