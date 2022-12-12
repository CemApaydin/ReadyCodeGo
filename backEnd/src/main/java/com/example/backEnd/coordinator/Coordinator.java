package com.example.backEnd.coordinator;

import com.example.backEnd.application.Application;
import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.university.University;
import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="coordinator")
@Data
@CrossOrigin
public class Coordinator extends User {

    @OneToMany
    private Set<ToDoList> doneList;
    @OneToMany
    private Set<University> universityList;
    @OneToMany
    private Set<Application> applicationList;

    public Coordinator(Long userID,
                       String userType,
                       String userMail,
                       String password,
                       String name,
                       String department,
                       ToDoList toDoList) {
        super(userID, userType, userMail, password, name, department, toDoList);
    }

    public Coordinator() {
        super();
    }

    public Coordinator(Long userID,
                       String userType,
                       String userMail,
                       String password,
                       String name,
                       String department,
                       ToDoList toDoList,
                       Set<ToDoList> doneList,
                       Set<University> universityList,
                       Set<Application> applicationList) {
        super(userID, userType, userMail, password, name, department, toDoList);
        this.doneList = doneList;
        this.universityList = universityList;
        this.applicationList = applicationList;
    }

    public Coordinator(Set<ToDoList> doneList, Set<University> universityList, Set<Application> applicationList) {
        super();
        this.doneList = doneList;
        this.universityList = universityList;
        this.applicationList = applicationList;
    }

    public Set<ToDoList> getDoneList() {
        return doneList;
    }

    public void setDoneList(Set<ToDoList> doneList) {
        this.doneList = doneList;
    }

    public Set<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(Set<University> universityList) {
        this.universityList = universityList;
    }

    public Set<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(Set<Application> applicationList) {
        this.applicationList = applicationList;
    }
}
