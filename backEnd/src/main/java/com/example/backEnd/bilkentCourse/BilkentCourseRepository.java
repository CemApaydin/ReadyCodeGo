package com.example.backEnd.bilkentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilkentCourseRepository extends JpaRepository<BilkentCourse, String> {
}
