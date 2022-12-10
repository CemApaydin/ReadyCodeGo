package com.example.backEnd.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="waitingbin")
@Data
@CrossOrigin
public class WaitingBin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waitingBinId;
    @OneToMany
    private Set<Student> studentList;

    public Long getWaitingBinId() {
        return waitingBinId;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }
}
