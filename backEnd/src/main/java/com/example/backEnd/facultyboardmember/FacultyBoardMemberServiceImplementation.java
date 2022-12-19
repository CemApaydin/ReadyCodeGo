package com.example.backEnd.facultyboardmember;

import com.example.backEnd.coordinator.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyBoardMemberServiceImplementation implements FacultyBoardMemberService {
    private final FacultyBoardMemberRepository facultyBoardMemberRepository;

    @Autowired
    public FacultyBoardMemberServiceImplementation(FacultyBoardMemberRepository facultyBoardMemberRepository) {
        this.facultyBoardMemberRepository = facultyBoardMemberRepository;
    }

    @Override
    public FacultyBoardMember saveFacultyBoardMember(FacultyBoardMember facultyBoardMember) {
        return facultyBoardMemberRepository.save(facultyBoardMember);
    }

    @Override
    public List<FacultyBoardMember> getAllFacultyBoardMembers() {
        return facultyBoardMemberRepository.findAll();
    }

    @Override
    public FacultyBoardMember findById(Long userId) {
        return facultyBoardMemberRepository.findById(userId).orElse(null);
    }

}
