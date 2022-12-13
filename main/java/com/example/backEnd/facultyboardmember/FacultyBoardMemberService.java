package com.example.backEnd.facultyboardmember;

import java.util.List;

public interface FacultyBoardMemberService {
    public FacultyBoardMember saveFacultyBoardMember(FacultyBoardMember facultyBoardMember);
    public List<FacultyBoardMember> getAllFacultyBoardMembers();
    public FacultyBoardMember findById(Long userId);
}
