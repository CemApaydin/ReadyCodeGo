package com.example.backEnd.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/findAll")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    @PostMapping("/createCourse")
    public String createCourse(@RequestBody Course newCourse)
    {

        courseService.saveCourse(newCourse);
        return "Adding Done!!";
    }
    @GetMapping("/{courseID}")
    public Course getOneCourse(@PathVariable String courseID)
    {
        return courseService.findById(courseID);
    }
    @GetMapping("/course/{courseID}")
    public Course getOneCourseA(@PathVariable String courseID)
    {
        return courseService.findById(courseID);
    }

}
