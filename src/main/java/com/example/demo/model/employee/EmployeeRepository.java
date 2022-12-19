package com.example.demo.model.employee;

import com.example.demo.model.user.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getEmployees();
     @Query(value = "update employee set name=:name where id=:id",nativeQuery = true)
    boolean updateEmployee(@Param("name") String name, @Param("id") int id);

     Page<Employee> findAllEmployees(Pageable pageable);
}