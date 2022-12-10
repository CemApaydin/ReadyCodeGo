package com.example.backEnd.entity;

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
