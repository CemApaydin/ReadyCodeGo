package com.example.backEnd.instructor;
import com.example.backEnd.instructor.Instructor;
import com.example.backEnd.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends UserRepository<Instructor> {
}
