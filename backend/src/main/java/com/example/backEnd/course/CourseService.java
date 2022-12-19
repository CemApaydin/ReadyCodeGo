package com.example.backEnd.course;

import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);
    public List<Course> getAllCourses();
    public Course findById(String courseId);
}
