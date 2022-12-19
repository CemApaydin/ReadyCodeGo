package com.example.backEnd.todolist;

import java.util.List;

public interface ToDoListService {
    public ToDoList saveToDoList(ToDoList toDoList);
    public List<ToDoList> getAllToDoLists();
    public ToDoList findById(Long toDoListId);
}
