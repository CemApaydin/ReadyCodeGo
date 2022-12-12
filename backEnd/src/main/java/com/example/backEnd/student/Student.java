package com.example.backEnd.student;

import com.example.backEnd.application.Application;
import com.example.backEnd.coordinator.Coordinator;
import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="student")
@Data
@CrossOrigin
public class Student extends User {
    @OneToOne
    private Application application;
    @ManyToOne
    private Coordinator coordinator;
    private boolean isPlaced;

    public Student(Long userID,
                   String userType,
                   String userMail,
                   String password,
                   String name,
                   String department,
                   ToDoList toDoList,
                   Application application,
                   Coordinator coordinator,
                   boolean isPlaced) {
        super(userID, userType, userMail, password, name, department, toDoList);
        this.application = application;
        this.coordinator = coordinator;
        this.isPlaced = isPlaced;
    }

    public Student(Application application, Coordinator coordinator, boolean isPlaced) {
        this.application = application;
        this.coordinator = coordinator;
        this.isPlaced = isPlaced;
    }

    public Student() {
    }

    public Application getApplication() {
        return application;
    }
    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
