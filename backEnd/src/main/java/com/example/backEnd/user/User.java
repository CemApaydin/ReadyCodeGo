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

    @OneToOne(cascade = {CascadeType.ALL})
    private ToDoList toDoList;


    public User(Long userID, String userType, String userMail, String password, String name, String department) {
        this.userID = userID;
        this.userType = userType;
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.department = department;
        toDoList = new ToDoList();
    }

    public User(Long userID, String userType, String userMail, String password, String name) {
        this.userID = userID;
        this.userType = userType;
        this.userMail = userMail;
        this.password = password;
        this.name = name;
        this.department = "NA";
        toDoList = new ToDoList();
    }

    public User(String userType) {
        this.userID = null;
        this.userType = userType;
        this.userMail = null;
        this.password = null;
        this.name = null;
        this.department = null;
        toDoList = new ToDoList();


    }
    public User() {
        this.userID = null;
        this.userType = null;
        this.userMail = null;
        this.password = null;
        this.name = null;
        this.department = null;
        toDoList = new ToDoList();

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

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public void addToActiveTasks(Long taskId){
        toDoList.addToActiveTasks(taskId);
    }

    public void addToGivenTasks(Long taskId){
        toDoList.addToGivenTasks(taskId);
    }

    public void addToDoneTasks(Long taskId){
        toDoList.addToDoneTasks(taskId);
    }

    public void markAsDoneTask(Long taskId){
        toDoList.markAsDoneTask(taskId);
    }

}