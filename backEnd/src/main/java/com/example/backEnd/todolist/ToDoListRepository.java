package com.example.backEnd.todolist;
import com.example.backEnd.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, User> {
}
