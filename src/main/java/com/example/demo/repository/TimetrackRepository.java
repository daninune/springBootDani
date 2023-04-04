package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Timetrack;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TimetrackRepository extends JpaRepository<Timetrack, Integer> {

    List<Timetrack> findByEmployee(Employee employee);



    List<Timetrack> findTimetracksByEmployeeEqualsAndDateBetween(Employee employee, LocalDate dateStart, LocalDate dateEnd);
}