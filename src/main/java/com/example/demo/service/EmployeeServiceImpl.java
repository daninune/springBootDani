package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        System.out.println("FindByiD: " + id);
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee savePartial(Employee e) {
        Employee employeePartial = employeeRepository.findById(e.getId()).orElse(null);
        System.out.println(e.getAddress() + " -- " + employeePartial.getAddress());
        if (employeePartial != null) {
            employeePartial.setTel(e.getTel());
            employeePartial.setIban(e.getIban());
            employeePartial.setEmail(e.getEmail());
            employeePartial.setAddress(e.getAddress());
            employeePartial.setCity(e.getCity());
            employeePartial.setIdprovince(e.getIdprovince());
            employeePartial.setCountry(e.getCountry());
            employeePartial.setZip(e.getZip());
            employeePartial.setIdschedule(e.getIdschedule());
            return employeeRepository.saveAndFlush(employeePartial);
        }
        return null;
    }

    @Override
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Boolean existsById(Integer id) {
        return employeeRepository.existsById(id);
    }
}
