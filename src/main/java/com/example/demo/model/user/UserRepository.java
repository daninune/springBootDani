package com.example.demo.model.user;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select U from user where username=:username", nativeQuery = true)
    User getUserByName(@Param("username") String userName);
    @Query(value = "select * from user", nativeQuery = true)
    Page<User> findUsers(Pageable pageable);
    @Query(value = "select U from user", nativeQuery = true)
    ArrayList<User> GetAllUsers();
}
