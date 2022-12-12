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

    @OneToMany
    private Set<ToDoList> doneList;

    public FacultyBoardMember() {
        super();
    }

    public FacultyBoardMember(Long userID, String userType, String userMail, String password, String name, String department, ToDoList toDoList, Set<ToDoList> doneList) {
        super(userID, userType, userMail, password, name, department, toDoList);
        this.doneList = doneList;
    }

    public FacultyBoardMember(Long userID, String userType, String userMail, String password, String name, String department, ToDoList toDoList) {
        super(userID, userType, userMail, password, name, department, toDoList);
    }

    public FacultyBoardMember(Set<ToDoList> doneList) {
        this.doneList = doneList;
    }

    public Set<ToDoList> getDoneList() {
        return doneList;
    }

    public void setDoneList(Set<ToDoList> doneList) {
        this.doneList = doneList;
    }
}
