package com.example.backEnd.user;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User findById(Long userId);
}
