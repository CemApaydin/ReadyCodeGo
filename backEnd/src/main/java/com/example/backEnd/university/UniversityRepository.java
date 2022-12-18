package com.example.backEnd.university;
import com.example.backEnd.university.University;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query("SELECT u FROM University u WHERE u.universityName = :universityName")
    public Optional<University> findByName(@Param("universityName") String universityName);
}
