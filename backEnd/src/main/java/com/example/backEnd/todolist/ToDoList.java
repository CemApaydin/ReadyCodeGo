package com.example.backEnd.todolist;

import com.example.backEnd.task.Task;
import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="todolist")
@Data
@CrossOrigin
public class ToDoList {
    @Id
    @OneToOne
    private User owner;
    @OneToMany
    private Set<Task> tasks;

    public ToDoList(User owner, Set<Task> tasks) {
        this.owner = owner;
        this.tasks = tasks;
    }

    public ToDoList() {
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
