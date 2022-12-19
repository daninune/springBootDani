package com.example.demo.model.user;

import com.example.demo.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
@Service
public class UserService implements UserDAO{
@Autowired
private UserRepository userRepository;
    @Override
    public void save(User u) {
        userRepository.save(u);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.getUserByName(username);
    }

    @Override
    public ArrayList<User> GetAllUsers() {
        return userRepository.GetAllUsers();
    }

    @Override
    public Page<User> findAllUsers(Pageable pageable) {
        return userRepository.findAllUsers(pageable);
    }


/*
    @Override
    public Page<User> findUsers(Pageable pageable) {
        return userRepos;
    }*/
}
