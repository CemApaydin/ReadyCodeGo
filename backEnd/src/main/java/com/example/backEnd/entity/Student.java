package com.example.backEnd.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="student")
@Data
@CrossOrigin
public class Student extends User {
    @OneToOne
    private Application application;
    @ManyToOne
    private Coordinator coordinator;
    private boolean isPlaced;


    public Application getApplication() {
        return application;
    }
    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
