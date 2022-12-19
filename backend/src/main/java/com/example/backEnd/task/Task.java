package com.example.backEnd.task;

import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.attachment.AttachmentGroup;
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
    @OneToOne(cascade = {CascadeType.ALL})
    private AttachmentGroup senderAttachmentGroup;
    @OneToOne(cascade = {CascadeType.ALL})
    private AttachmentGroup receiverAttachmentGroup;


    public Task(String taskName, Long taskSenderId, Long taskReceiverId, String text, String taskStatus, String dueDate, boolean done) {
        this.taskName = taskName;
        this.taskSenderId = taskSenderId;
        this.taskReceiverId = taskReceiverId;
        this.text = text;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.done = done;
        senderAttachmentGroup = new AttachmentGroup();
        receiverAttachmentGroup = new AttachmentGroup();
    }

    public Task() {
        this.taskName = null;
        this.taskSenderId = null;
        this.taskReceiverId = null;
        this.text = null;
        this.taskStatus = null;
        this.dueDate = null;
        senderAttachmentGroup = new AttachmentGroup();
        receiverAttachmentGroup = new AttachmentGroup();
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
    public void addToSenderAttachments(AttachmentComponent attachmentComponent) {
        senderAttachmentGroup.addComponent(attachmentComponent);
    }
    public void addToReceiverAttachments(AttachmentComponent attachmentComponent) {
        receiverAttachmentGroup.addComponent(attachmentComponent);
    }

    public AttachmentGroup getSenderAttachmentGroup() {
        return senderAttachmentGroup;
    }

    public void setSenderAttachmentGroup(AttachmentGroup senderAttachmentGroup) {
        this.senderAttachmentGroup = senderAttachmentGroup;
    }

    public AttachmentGroup getReceiverAttachmentGroup() {
        return receiverAttachmentGroup;
    }

    public void setReceiverAttachmentGroup(AttachmentGroup receiverAttachmentGroup) {
        this.receiverAttachmentGroup = receiverAttachmentGroup;
    }
}
