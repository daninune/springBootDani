package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Timetrack;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TimetrackService {
    List<Timetrack> findAllTimetracks();

    Timetrack findTimetrackById(Integer id);

    Timetrack save(Timetrack timetrack);

    List<Timetrack> saveAll(List<Timetrack> timetracks);

    List<Timetrack> findByEmployeeId(Integer employeeId);

    List<Timetrack> findTimetracksByEmployeeEqualsAndDateBetween(Employee employee, LocalDate dateStart, LocalDate dateEnd);


}
