package com.example.backEnd.task;

import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.todolist.ToDoListRepository;
import com.example.backEnd.user.User;
import com.example.backEnd.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ToDoListRepository toDoListRepository;

    public TaskServiceImplementation(TaskRepository taskRepository, UserRepository userRepository, ToDoListRepository toDoListRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public Task saveTask(Task task) {
        User receiver = userRepository.findById(task.getTaskReceiverId()).orElse(null);
        User sender = userRepository.findById(task.getTaskSenderId()).orElse(null);
        if ( receiver == null || sender == null){
            return null;
        }
        taskRepository.save(task);
        receiver.addToActiveTasks(task.getTaskId());
        sender.addToGivenTasks(task.getTaskId());
        userRepository.save(receiver);
        userRepository.save(sender);
        return task;
    }

    @Override
    public  Task updateStatus(Task task, String newStatus){
        task.setTaskStatus(newStatus);
        return taskRepository.save(task);
    }

    @Override
    public Task updateText(Task task, String newText){
        task.setText(newText);
        return taskRepository.save(task);
    }

    @Override
    public  Task setDone(Task task){
        task.setDone(true);
        task.setTaskStatus("done");
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
