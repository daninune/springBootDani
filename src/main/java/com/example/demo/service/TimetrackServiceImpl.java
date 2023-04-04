package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Timetrack;
import com.example.demo.repository.TimetrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TimetrackServiceImpl implements TimetrackService {

    @Autowired
    private TimetrackRepository timetrackRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Timetrack> findAllTimetracks() {
        return timetrackRepository.findAll();
    }

    @Override
    public Timetrack findTimetrackById(Integer id) {
        return timetrackRepository.findById(id).orElse(null);
    }

    public Timetrack save(Timetrack timetrack) {
        return timetrackRepository.save(timetrack);
    }


    @Override
    public List<Timetrack> saveAll(List<Timetrack> timetracks) {
        return timetrackRepository.saveAll(timetracks);
    }

    @Override
    public List<Timetrack> findByEmployeeId(Integer employeeId){
        Employee employee = employeeService.findById(employeeId);
        return timetrackRepository.findByEmployee(employee);
    }

    @Override
    public List<Timetrack> findTimetracksByEmployeeEqualsAndDateBetween(Employee employee, LocalDate dateStart, LocalDate dateEnd) {
        return timetrackRepository.findTimetracksByEmployeeEqualsAndDateBetween(employee,dateStart,dateEnd);
    }


}
