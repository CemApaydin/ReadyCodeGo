package com.example.backEnd.task;

import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="task")
@Data
@CrossOrigin
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskName;
    private Long taskSenderId;
    private Long taskReceiverId;
    private String text;
    private String taskStatus;
    private String dueDate;
    private boolean done;
    @ElementCollection

    private Set<Long> senderDocumentIds;
    @ElementCollection

    private Set<Long> receiverDocumentIds;


    public Task(String taskName, Long taskSenderId, Long taskReceiverId, String text, String taskStatus, String dueDate, boolean done) {
        this.taskName = taskName;
        this.taskSenderId = taskSenderId;
        this.taskReceiverId = taskReceiverId;
        this.text = text;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.done = done;
        senderDocumentIds = null;
        receiverDocumentIds = null;
    }

    public Task() {
        this.taskName = null;
        this.taskSenderId = null;
        this.taskReceiverId = null;
        this.text = null;
        this.taskStatus = null;
        this.dueDate = null;
        senderDocumentIds = null;
        receiverDocumentIds = null;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getTaskSenderId() {
        return taskSenderId;
    }

    public void setTaskSenderId(Long taskSenderId) {
        this.taskSenderId = taskSenderId;
    }

    public Long getTaskReceiverId() {
        return taskReceiverId;
    }

    public void setTaskReceiverId(Long taskReceiverId) {
        this.taskReceiverId = taskReceiverId;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    public void addToSenderDocumentIds(Long a) {
        senderDocumentIds.add(a);
    }
    public void addToReceiverDocumentIds(Long a) {
        receiverDocumentIds.add(a);
    }

}
