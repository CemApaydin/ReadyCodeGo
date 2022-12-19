package com.example.backEnd.task;

import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.attachment.AttachmentComponentRepository;
import com.example.backEnd.attachment.AttachmentGroup;
import com.example.backEnd.attachment.AttachmentGroupRepository;
import com.example.backEnd.user.User;
import com.example.backEnd.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final AttachmentGroupRepository attachmentGroupRepository;
    private final AttachmentComponentRepository attachmentComponentRepository;

    public TaskServiceImplementation(TaskRepository taskRepository, UserRepository userRepository, AttachmentGroupRepository attachmentGroupRepository, AttachmentComponentRepository attachmentComponentRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.attachmentGroupRepository = attachmentGroupRepository;
        this.attachmentComponentRepository = attachmentComponentRepository;
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
    public Task addAttachment(Task task, AttachmentComponent attachmentComponent){
        User receiver = userRepository.findById(task.getTaskReceiverId()).orElse(null);
        User sender = userRepository.findById(task.getTaskSenderId()).orElse(null);
        AttachmentGroup receiverAttachments = task.getReceiverAttachmentGroup();
        AttachmentGroup senderAttachments = task.getSenderAttachmentGroup();
        if ( receiver == null || sender == null || attachmentComponent == null){
            return null;
        }
        attachmentComponentRepository.save(attachmentComponent);
        if (attachmentComponent.getUploaderId().longValue() == sender.getUserID().longValue()){
            task.addToSenderAttachments(attachmentComponent);
        }
        else if (attachmentComponent.getUploaderId().longValue() == receiver.getUserID().longValue()){
            task.addToReceiverAttachments(attachmentComponent);
        }
        attachmentComponentRepository.save(senderAttachments);
        attachmentComponentRepository.save(receiverAttachments);
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
