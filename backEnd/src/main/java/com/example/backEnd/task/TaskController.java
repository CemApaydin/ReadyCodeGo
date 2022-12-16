package com.example.backEnd.task;

import com.example.backEnd.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final DocumentService documentService;

    @Autowired
    public TaskController(TaskService taskService, DocumentService documentService) {
        this.taskService = taskService;
        this.documentService = documentService;
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

    @PostMapping("/updateStatus/{taskId}")
    public Task updateStatus(@PathVariable Long taskId, @RequestBody String newStatus){
        return taskService.updateStatus(taskService.findById(taskId),newStatus);
    }

    @PostMapping("/addDocument/{taskId}")
    public Task addDocument(@PathVariable Long taskId, @RequestBody Long documentId){
        return taskService.addDocument(taskService.findById(taskId), documentService.findById(documentId));
    }

    @PostMapping("/setDone/{taskId}")
    public Task setDone(@PathVariable Long taskId){
        return taskService.setDone(taskService.findById(taskId));
    }

    @PostMapping("/updateText/{taskId}")
    public Task updateText(@PathVariable Long taskId, @RequestBody String newText){
        return taskService.updateText(taskService.findById(taskId),newText);
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
