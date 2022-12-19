package com.example.backEnd.course;

import com.example.backEnd.student.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.backEnd.university.*;

@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;
    private final UniversityRepository universityRepository;


    public CourseServiceImplementation(CourseRepository courseRepository, UniversityRepository universityRepository) {
        this.courseRepository = courseRepository;
        this.universityRepository = universityRepository;
    }

    @Override
    public Course saveCourse(Course course) {
    //TRANSCRİPT repo eklenecek ve transcripte ail olan courselar devam edecek

        University university = universityRepository.findById(course.getUniversityId()).orElse(null);

        if(university == null) {
            return null;
        }
        university.addToCourseIdsList(course.getCourseID());

        universityRepository.save(university);
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
