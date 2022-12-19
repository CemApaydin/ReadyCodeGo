package com.example.backEnd.facultyboardmember;
import com.example.backEnd.coordinator.Coordinator;
import com.example.backEnd.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyBoardMemberRepository extends JpaRepository<FacultyBoardMember, Long> {
}
