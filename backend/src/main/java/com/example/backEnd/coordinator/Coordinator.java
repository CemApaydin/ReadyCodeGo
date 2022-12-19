package com.example.backEnd.coordinator;

import com.example.backEnd.application.Application;
import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.university.University;
import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="coordinator")
@Data
@CrossOrigin
public class Coordinator extends User {

    @ElementCollection
    private List<Long> universityIdList;
    @ElementCollection
    private List<Long> applicationIdList;

    public Coordinator(Long userID, String userMail, String password, String name, String department, List<Long> universityIdList, List<Long> applicationIdList) {
        super(userID, "coordinator", userMail, password, name, department);
        this.universityIdList = universityIdList;
        this.applicationIdList = applicationIdList;
    }

    public Coordinator(Long userID, String userMail, String password, String name, List<Long> universityIdList, List<Long> applicationIdList) {
        super(userID, "coordinator", userMail, password, name);
        this.universityIdList = universityIdList;
        this.applicationIdList = applicationIdList;
    }

    public Coordinator(Long userID, String userMail, String password, String name, String department) {
        super(userID, "coordinator", userMail, password, name, department);
        this.universityIdList = null;
        this.applicationIdList = null;
    }

    public Coordinator(Long userID, String userMail, String password, String name) {
        super(userID, "coordinator", userMail, password, name);
        this.universityIdList = null;
        this.applicationIdList = null;
    }

    public Coordinator() {
        super("coordinator");
    }

    public List<Long> getUniversityIdList() {
        return universityIdList;
    }

    public void setUniversityIdList(List<Long> universityIdList) {
        this.universityIdList = universityIdList;
    }

    public void addUniversityIdList(Long universityId) {
        this.universityIdList.add(universityId);
    }

    public List<Long> getApplicationIdList() {
        return applicationIdList;
    }

    public void setApplicationIdList(List<Long> applicationIdList) {
        this.applicationIdList = applicationIdList;
    }
    public void addApplicationIdList(Long universityId) {         this.applicationIdList.add(universityId);     }
}
