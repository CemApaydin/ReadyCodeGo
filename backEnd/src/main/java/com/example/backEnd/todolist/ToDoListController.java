package com.example.backEnd.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/toDoList")
public class ToDoListController {
    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping("/findAll")
    public List<ToDoList> getAllToDoLists()
    {
        return toDoListService.getAllToDoLists();
    }

    @PostMapping("/createToDoList")
    public String createToDoList(@RequestBody ToDoList newToDoList)
    {

        toDoListService.saveToDoList(newToDoList);
        return "Adding Done!!";
    }
    @GetMapping("/{toDoListID}")
    public ToDoList getOneToDoList(@PathVariable Long toDoListID)
    {
        return toDoListService.findById(toDoListID);
    }
    @GetMapping("/toDoList/{toDoListID}")
    public ToDoList getOneToDoListA(@PathVariable Long toDoListID)
    {
        return toDoListService.findById(toDoListID);
    }

}
