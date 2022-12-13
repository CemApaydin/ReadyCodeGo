package com.example.backEnd.bilkentCourse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilkentCourseServiceImplementation implements BilkentCourseService {
    private final BilkentCourseRepository bilkentCourseRepository;

    public BilkentCourseServiceImplementation(BilkentCourseRepository bilkentCourseRepository) {
        this.bilkentCourseRepository = bilkentCourseRepository;
    }

    @Override
    public BilkentCourse saveBilkentCourse(BilkentCourse bilkentCourse) {
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
