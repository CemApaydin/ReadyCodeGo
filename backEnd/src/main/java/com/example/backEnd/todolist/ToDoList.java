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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;
    @ElementCollection
    private Set<Long> activeTaskIds;
    @ElementCollection
    private Set<Long> doneTaskIds;
    @ElementCollection
    private Set<Long> givenTaskIds;

    public ToDoList( Set<Long> activeTaskIds, Set<Long> doneTaskIds) {
        this.activeTaskIds = activeTaskIds;
        this.doneTaskIds = doneTaskIds;
    }

    public ToDoList() {
        this.activeTaskIds = null;
        this.doneTaskIds = null;
    }

    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public Set<Long> getActiveTaskIds() {
        return activeTaskIds;
    }

    public void setActiveTaskIds(Set<Long> activeTaskIds) {
        this.activeTaskIds = activeTaskIds;
    }

    public Set<Long> getDoneTaskIds() {
        return doneTaskIds;
    }

    public void setDoneTaskIds(Set<Long> doneTaskIds) {
        this.doneTaskIds = doneTaskIds;
    }
}
