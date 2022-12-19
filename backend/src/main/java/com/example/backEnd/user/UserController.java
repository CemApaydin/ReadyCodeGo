package com.example.backEnd.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backEnd.todolist.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User newUser)
    {

        userService.saveUser(newUser);
        return "Adding Done!!";
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId)
    {
        return userService.findById(userId);
    }
    @GetMapping("/getToDo/{userId}")
    public Long getOneUserA(@PathVariable Long userId)
    {
        return userService.findById(userId).getToDoList().getToDoListId();
    }


}
