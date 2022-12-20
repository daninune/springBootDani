package com.example.demo.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Iterable<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.getUserByName(username);
    }

    @Override
    public ArrayList<User> GetAllUsers() {
        return null;
    }

    @Override
    public Page<User> findPaginated(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return userRepository.findUsers(pageable);
    }


}
