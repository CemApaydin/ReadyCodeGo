package com.example.backEnd.instructor;

import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.user.User;
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

    public Instructor(Long userID,
                      String userType,
                      String userMail,
                      String password,
                      String name,
                      String department,
                      ToDoList toDoList,
                      Set<String> relatedCourses,
                      Set<ToDoList> doneList) {
        super(userID, userType, userMail, password, name, department, toDoList);
        this.relatedCourses = relatedCourses;
        this.doneList = doneList;
    }

    public Instructor(Set<String> relatedCourses, Set<ToDoList> doneList) {
        super();
        this.relatedCourses = relatedCourses;
        this.doneList = doneList;
    }

    public Instructor() {
        super();
    }

    public Set<String> getRelatedCourses() {
        return relatedCourses;
    }

    public Set<ToDoList> getDoneList() {
        return doneList;
    }
}