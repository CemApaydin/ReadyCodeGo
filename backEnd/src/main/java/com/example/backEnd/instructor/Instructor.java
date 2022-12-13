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
    private Set<String> relatedCourseIds;

    public Instructor(Long userID, String userMail, String password, String name, String department, Long toDoListId, Set<String> relatedCourseIds) {
        super(userID, "instructor", userMail, password, name, department, toDoListId);
        this.relatedCourseIds = relatedCourseIds;
    }

    public Instructor(Long userID, String userMail, String password, String name, String department, Long toDoListId) {
        super(userID, "instructor", userMail, password, name, department, toDoListId);
        this.relatedCourseIds = null;
    }

    public Instructor() {
        super("instructor");
    }

    public Set<String> getRelatedCourseIds() {
        return relatedCourseIds;
    }

    public void setRelatedCourseIds(Set<String> relatedCourseIds) {
        this.relatedCourseIds = relatedCourseIds;
    }
}