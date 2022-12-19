package com.example.backEnd.key;
import com.example.backEnd.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {

}
