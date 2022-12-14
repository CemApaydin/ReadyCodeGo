package com.example.backEnd.facultyboardmember;

import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="facultyboardmember")
@Data
@CrossOrigin
public class FacultyBoardMember extends User {
    public FacultyBoardMember(Long userID,String userMail, String password, String name, String department) {
        super(userID, "facultyboardmember", userMail, password, name, department);
    }

    public FacultyBoardMember(Long userID, String userMail, String password, String name) {
        super(userID, "facultyboardmember", userMail, password, name);
    }

    public FacultyBoardMember() {
        super("facultyboardmember");
    }
}
