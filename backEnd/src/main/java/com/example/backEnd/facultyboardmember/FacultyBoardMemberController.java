package com.example.backEnd.facultyboardmember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/facultyboardmember")
public class FacultyBoardMemberController {
    private final FacultyBoardMemberService facultyBoardMemberService;

    @Autowired
    public FacultyBoardMemberController(FacultyBoardMemberService facultyBoardMemberService) {
        this.facultyBoardMemberService = facultyBoardMemberService;
    }

    @GetMapping("/findAll")
    public List<FacultyBoardMember> getAllFacultyBoardMembers() {
        return facultyBoardMemberService.getAllFacultyBoardMembers();
    }

    @PostMapping("/createFacultyBoardMember")
    public String createFacultyBoardMember(@RequestBody FacultyBoardMember newFacultyBoardMember){
        facultyBoardMemberService.saveFacultyBoardMember(newFacultyBoardMember);
        return "Adding Done!!";
    }

    @GetMapping("/{userId}")
    public FacultyBoardMember getOneFacultyBoardMember(@PathVariable Long userId){
        return facultyBoardMemberService.findById(userId);
    }

    @GetMapping("/facultyboardmember/{userId}")
    public FacultyBoardMember getOneFacultyBoardMemberA(@PathVariable Long userId){
        return facultyBoardMemberService.findById(userId);
    }

}
