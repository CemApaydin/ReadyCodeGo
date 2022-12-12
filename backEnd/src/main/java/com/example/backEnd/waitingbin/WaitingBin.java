package com.example.backEnd.waitingbin;

import com.example.backEnd.student.Student;
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

    public WaitingBin(Long waitingBinId, Set<Student> studentList) {
        this.waitingBinId = waitingBinId;
        this.studentList = studentList;
    }

    public WaitingBin() {
    }

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
