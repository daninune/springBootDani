package com.example.demo.models.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testGetEmployees() {
        List<Employee> employees = employeeRepository.getEmployees();
        assertThat(employees.size()).isNotNull();
        assertThat(employees.size()).isGreaterThan(0);
    }

    @Test
    public void testFindById() {
        Optional<Employee> employee = employeeRepository.findById(1);
        assertThat(employee.isPresent()).isTrue();
        assertThat(employee.get().getName()).isEqualTo("Adán");
    }

    @Test
    public void testFindAll() {
        Iterable<Employee> employees = employeeRepository.findAll();
        assertThat(employees).isNotNull();
        assertThat(employees).size().isGreaterThan(0);
    }

    @Test
    @Rollback
    @Transactional
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("Test");
        employeeRepository.save(employee);
        //assertThat(employee.getId()).isNotNull();
    }

    @Test
    @Rollback
    @Transactional
    public void testDeleteById(){
        employeeRepository.deleteById(1);
        assertThat(employeeRepository.findAll()).isNotNull();
        assertThat(employeeRepository.findAll()).size().isGreaterThan(0);
    }

}
