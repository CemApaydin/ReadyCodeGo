package com.example.backEnd.task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTasks();
    public Task findById(Long taskId);
}
