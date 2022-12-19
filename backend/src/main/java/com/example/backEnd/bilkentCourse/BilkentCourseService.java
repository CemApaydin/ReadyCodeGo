package com.example.backEnd.bilkentCourse;

import java.util.List;
import com.example.backEnd.instructor.*;
public interface BilkentCourseService {
    public BilkentCourse saveBilkentCourse(BilkentCourse bilkentCourse);
    public List<BilkentCourse> getAllBilkentCourses();
    public BilkentCourse findById(String courseId);
}
