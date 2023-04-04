package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    User findUserById(Integer id);

    void saveUser(User user);

}
