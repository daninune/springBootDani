package com.example.demo.model.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee findById(int id);

    Iterable<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    void deleteById(int id);
    Page<Employee> findAllEmployees(Pageable pageable);

    long count();
}