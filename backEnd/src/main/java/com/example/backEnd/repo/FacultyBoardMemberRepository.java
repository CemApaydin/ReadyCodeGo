package com.example.backEnd.repo;
import com.example.backEnd.entity.FacultyBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyBoardMemberRepository extends JpaRepository<FacultyBoardMember, Long> {
}
