package com.example.backEnd.facultyboardmember;
import com.example.backEnd.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyBoardMemberRepository extends UserRepository<FacultyBoardMember> {
}
