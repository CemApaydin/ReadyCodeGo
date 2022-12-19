package com.example.backEnd.bilkentCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.backEnd.instructor.*;
@RestController
@CrossOrigin
@RequestMapping("/bilkentcourse")
public class BilkentCourseController {
    private final BilkentCourseService bilkentCourseService;

    @Autowired
    public BilkentCourseController(BilkentCourseService bilkentCourseService) {
        this.bilkentCourseService = bilkentCourseService;
    }

    @GetMapping("/findAll")
    public List<BilkentCourse> getAllBilkentCourses()
    {
        return bilkentCourseService.getAllBilkentCourses();
    }

    @PostMapping("/createBilkentCourse")
    public String createBilkentCourse(@RequestBody BilkentCourse newBilkentCourse)
    {

        bilkentCourseService.saveBilkentCourse(newBilkentCourse);
        return "Adding Done!!";
    }
    @GetMapping("/{courseID}")
    public BilkentCourse getOneBilkentCourse(@PathVariable String courseID)
    {
        return bilkentCourseService.findById(courseID);
    }
    @GetMapping("/bilkentCourse/{courseID}")
    public BilkentCourse getOneBilkentCourseA(@PathVariable String courseID)
    {
        return bilkentCourseService.findById(courseID);
    }



}
