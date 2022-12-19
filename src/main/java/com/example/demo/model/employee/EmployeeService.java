package com.example.demo.model.employee;

// EmployeeService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class EmployeeService implements EmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {

        return employeeRepository.getEmployees();
    }

    public Iterable<Employee> findAll() {

        return employeeRepository.findAll();
    }

    public Employee findById(int id) {

        return employeeRepository.findById(id).orElse(null);
    }

    public void save(Employee employee) {

        employeeRepository.save(employee);
    }

    public void deleteById(int id) {

        employeeRepository.deleteById(id);
    }

/*    @Override
    public Page<Employee> findAllEmployees(Pageable pageable) {
        return employeeRepository.findAllEmployees(pageable);
    }

*/
}
