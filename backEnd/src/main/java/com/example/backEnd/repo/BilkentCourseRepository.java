package com.example.backEnd.repo;
import com.example.backEnd.entity.BilkentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilkentCourseRepository extends JpaRepository<BilkentCourse, String> {
}
