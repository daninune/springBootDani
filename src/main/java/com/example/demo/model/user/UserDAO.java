package com.example.demo.model.user;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.ArrayList;

public interface UserDAO {
    void save(User u);

    Iterable<User> findAll();
    User findByUsername(String username);
    ArrayList<User> GetAllUsers();

    Page <User> findPaginated(int pageNo, int pageSize);
}
