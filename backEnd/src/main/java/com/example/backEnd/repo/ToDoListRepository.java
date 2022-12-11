package com.example.backEnd.repo;
import com.example.backEnd.entity.ToDoList;
import com.example.backEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, User> {
}
