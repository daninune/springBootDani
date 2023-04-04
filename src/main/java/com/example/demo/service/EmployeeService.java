package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findById(Integer id);


    Employee savePartial(Employee e);
    Employee save(Employee e);
    Boolean existsById(Integer id);
}
