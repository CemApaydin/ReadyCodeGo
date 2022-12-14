package com.example.backEnd.user;

import com.example.backEnd.todolist.ToDoList;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="user")
@Data
@CrossOrigin
public abstract class User{

    @Id
    private Long userID;

    private String userType;
    private String userMail;
    private String password;
    private String name;
    private String department;
    private Long toDoListId;

    public User(Long userID, String userType, String userMail, String password, String name, String department) {
        this.userID = userID;
        this.userType = userType;
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.department = department;
        ToDoList toDoList = new ToDoList();
        this.toDoListId = toDoList.getToDoListId();
    }

    public User(Long userID, String userType, String userMail, String password, String name) {
        this.userID = userID;
        this.userType = userType;
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.department = "NA";
        ToDoList toDoList = new ToDoList();
        this.toDoListId = toDoList.getToDoListId();
    }

    public User(String userType) {
        this.userID = null;
        this.userType = userType;
        this.userMail = null;
        this.password = null;
        this.name = null;
        this.department = null;
        this.toDoListId = null;
    }
    public User() {
        this.userID = null;
        this.userType = null;
        this.userMail = null;
        this.password = null;
        this.name = null;
        this.department = null;
        this.toDoListId = null;
    }
}