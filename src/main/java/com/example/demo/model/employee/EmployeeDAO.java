package com.example.demo.model.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;


public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee findById(int id);

    Iterable<Employee> findAll();

    void save(Employee employee);

    void deleteById(int id);
    //Page<Employee> findAllEmployees(Pageable pageable);
}