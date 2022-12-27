package com.example.demo.model.employee;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
// EmployeeService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Iterable<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
          employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee=this.employeeRepository.findEmployeeById(id);
        employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllEmployees(Pageable pageable) {
        List<Employee> employees=this.employeeRepository.getEmployees();
        List<Employee> list = new ArrayList<Employee>();
        int pageSize=pageable.getPageSize();
        int currentPage=pageable.getPageNumber();
        int startItem=currentPage*pageSize;
        if(employees.size()<startItem){
            employees= Collections.emptyList();
        }else {
            int toIndex=Math.min(startItem+pageSize,employees.size());
            list=employees.subList(startItem,toIndex);
        }
        Page<Employee> employeePage=
                new PageImpl<Employee>(list,PageRequest.of(currentPage,pageSize),employees.size());
        return employeePage;
    }


    @Override
    public long count() {
        return 0;
    }
}
