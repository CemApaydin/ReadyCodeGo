package com.example.backEnd.task;

import java.util.List;

public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
}
