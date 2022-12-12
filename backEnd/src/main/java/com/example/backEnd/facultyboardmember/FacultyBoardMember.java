package com.example.backEnd.facultyboardmember;

import com.example.backEnd.todolist.ToDoList;
import com.example.backEnd.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="facultyboardmember")
@Data
@CrossOrigin
public class FacultyBoardMember extends User {

    @OneToMany
    private Set<ToDoList> doneList;

    public FacultyBoardMember() {
    }

    public Set<ToDoList> getDoneList() {
        return doneList;
    }

    public void setDoneList(Set<ToDoList> doneList) {
        this.doneList = doneList;
    }
}
