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
    private Long applicationId;
    private Long coordinatorId;
    private boolean isPlaced;
    private double placementGrade;

    public Student(Long userID, String userMail, String password, String name, String department, Long applicationId, Long coordinatorId, boolean isPlaced, double placementGrade) {
        super(userID, "student", userMail, password, name, department);
        this.applicationId = applicationId;
        this.coordinatorId = coordinatorId;
        this.isPlaced = isPlaced;
        this.placementGrade = placementGrade;
    }

    public Student(Long userID, String userMail, String password, String name, Long applicationId, Long coordinatorId, boolean isPlaced, double placementGrade) {
        super(userID, "student", userMail, password, name);
        this.applicationId = applicationId;
        this.coordinatorId = coordinatorId;
        this.isPlaced = isPlaced;
        this.placementGrade = placementGrade;
    }

    public Student(Long userID, String userMail, String password, String name, String department) {
        super(userID, "student", userMail, password, name, department);
        this.applicationId = null;
        this.coordinatorId = null;
        this.placementGrade = 0;
    }

    public Student(Long userID, String userMail, String password, String name) {
        super(userID, "student", userMail, password, name);
        this.applicationId = null;
        this.coordinatorId = null;
        this.placementGrade = 0;
    }

    public Student() {
        super("student");
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Long coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public double getPlacementGrade() {
        return placementGrade;
    }

    public void setPlacementGrade(double placementGrade) {
        this.placementGrade = placementGrade;
    }
}
