package com.example.backEnd.task;

import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="task")
@Data
@CrossOrigin
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;
    private String taskName;
    @ManyToOne
    private User taskGiver;
    @OneToOne
    private User taskReceiver;
    private String text;
    private String taskStatus;
    private String dueDate;

    public Task(Long taskID,
                String taskName,
                User taskGiver,
                User taskReceiver,
                String text,
                String taskStatus,
                String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskGiver = taskGiver;
        this.taskReceiver = taskReceiver;
        this.text = text;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
    }

    public Task() {
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public User getTaskGiver() {
        return taskGiver;
    }

    public void setTaskGiver(User taskGiver) {
        this.taskGiver = taskGiver;
    }

    public User getTaskReceiver() {
        return taskReceiver;
    }

    public void setTaskReceiver(User taskReceiver) {
        this.taskReceiver = taskReceiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
