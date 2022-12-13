package com.example.backEnd.course;

import java.util.List;

public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;


    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(String courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }
}
