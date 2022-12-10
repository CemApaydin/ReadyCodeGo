package com.example.backEnd.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Set;

@Entity
@Table(name="instructor")
@Data
@CrossOrigin
public class Instructor extends User {

    @ElementCollection
    private Set<String> relatedCourses;

    @OneToMany
    private Set<ToDoList> doneList;


    public Set<String> getRelatedCourses() {
        return relatedCourses;
    }

    public Set<ToDoList> getDoneList() {
        return doneList;
    }
}