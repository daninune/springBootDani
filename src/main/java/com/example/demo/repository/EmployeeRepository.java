package com.example.demo.repository;

import com.example.demo.model.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // get employee name
    @Query("SELECT e.name as name FROM Employee e")
    List<String> getEmployeeName();

    // get employee mail
    @Query("SELECT e.email as email FROM Employee e")
    List<String> getEmployeeEmail();

}