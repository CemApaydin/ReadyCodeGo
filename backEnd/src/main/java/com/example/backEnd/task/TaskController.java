package com.example.backEnd.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/findAll")
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @PostMapping("/createTask")
    public String createTask(@RequestBody Task newTask)
    {

        taskService.saveTask(newTask);
        return "Adding Done!!";
    }

    @GetMapping("/{taskID}")
    public Task getOneTask(@PathVariable Long taskID)
    {
        return taskService.findById(taskID);
    }
    @GetMapping("/task/{taskID}")
    public Task getOneTaskA(@PathVariable Long taskID)
    {
        return taskService.findById(taskID);
    }

}
