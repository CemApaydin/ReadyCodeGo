package com.example.backEnd.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="student")
@Data
@CrossOrigin
public class Student {
    @Id
    private Long id;
    private String name;

    private String surname;
    private String password;
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String type = "student";
    private int applicationID = 0;
    private int toDoListID = 0;

    public int getApplicationID() {
        return applicationID;
    }

    public int getToDoListID() {
        return toDoListID;
    }

    public String getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
