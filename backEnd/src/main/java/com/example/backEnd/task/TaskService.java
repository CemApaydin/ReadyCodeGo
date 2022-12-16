package com.example.backEnd.task;

import com.example.backEnd.document.Document;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public Task updateStatus(Task task, String newStatus);
    public Task updateText(Task task, String newText);
    public Task addDocument(Task task, Document document);
    public Task setDone(Task task);
    public List<Task> getAllTasks();
    public Task findById(Long taskId);
}
