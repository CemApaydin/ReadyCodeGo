package com.example.backEnd.coordinator;

import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import com.example.backEnd.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
}
