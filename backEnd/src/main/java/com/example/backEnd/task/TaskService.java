package com.example.backEnd.task;

import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.document.Document;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public Task updateStatus(Task task, String newStatus);
    public Task updateText(Task task, String newText);
    public Task addAttachment(Task task, AttachmentComponent attachmentComponent);
    public Task setDone(Task task);
    public List<Task> getAllTasks();
    public Task findById(Long taskId);
}
