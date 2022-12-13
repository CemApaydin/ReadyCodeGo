package com.example.backEnd.student;

import com.example.backEnd.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends UserRepository<Student> {

}
