package com.example.backEnd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="user")
@Data
@CrossOrigin
public class User{

    @Id
    private Long userID;

    private String userType;
    private String userMail;
    private String password;
    private String name;
    private String department;
    //ADD TODOLIST


    public Long getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}