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
    @OneToOne
    private ToDoList toDoList;

    public User(Long userID,
                String userType,
                String userMail,
                String password,
                String name,
                String department,
                ToDoList toDoList) {
        this.userID = userID;
        this.userType = userType;
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.department = department;
        this.toDoList = toDoList;
    }

    public User() {
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
}