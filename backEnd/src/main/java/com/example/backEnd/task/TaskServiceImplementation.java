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
        if(receiver != null && sender != null){
            ToDoList receiverList = toDoListRepository.findById(receiver.getToDoList().getToDoListId()).orElse(null);
            ToDoList senderList = toDoListRepository.findById(sender.getToDoList().getToDoListId()).orElse(null);
            if(receiverList != null && senderList != null){
                Set<Long> receiverListActive = receiverList.getActiveTaskIds();
                receiverListActive.add(task.getTaskId());
                receiverList.setActiveTaskIds(receiverListActive);

                Set<Long> senderListGiven = senderList.getGivenTaskIds();
                senderListGiven.add(task.getTaskId());
                senderList.setGivenTaskIds(senderListGiven);

                userRepository.flush();
                return taskRepository.save(task);
            }
        }
        return null;
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
