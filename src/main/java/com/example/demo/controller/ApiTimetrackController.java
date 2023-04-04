package com.example.demo.controller;


import com.example.demo.dto.TimetrackDTO;
import com.example.demo.mapper.TimetrackMapper;
import com.example.demo.model.Employee;
import com.example.demo.model.Timetrack;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TimetrackServiceImpl;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@RestController
@Validated
@RequestMapping("/timetrackApi")
public class ApiTimetrackController {
        @Autowired
        public TimetrackServiceImpl timetrackService;

        @Autowired
        private TimetrackMapper timetrackMapper;

        @Autowired
        private EmployeeService employeeService;

        @GetMapping("/list")
        public ResponseEntity<List<TimetrackDTO>> getList() {

            UserDetailsImpl logged = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Integer employeeId = logged.getId();

            if (employeeId == null) {
                return ResponseEntity.notFound().build(); // cod 404
            }

            List<Timetrack> timetracks = timetrackService.findByEmployeeId(employeeId);

            if (!timetracks.isEmpty()) {
                List<TimetrackDTO> timetrackDTOs = timetrackMapper.timetrackTotimetrackDto(timetracks);
                return ResponseEntity.ok(timetrackDTOs); //cod 200
            }
            return ResponseEntity.notFound().build(); // cod 404
        }

    @PostMapping("/save")
    public ResponseEntity<String> save (@Valid @RequestBody List<TimetrackDTO> timetrackDTO){

            List<Timetrack> timetracks = timetrackMapper.timetrackDtoTotimetrack(timetrackDTO);

            UserDetailsImpl logged = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Integer employeeId = logged.getId();

            boolean checkID = timetracks.stream().allMatch(timetrack -> timetrack.getEmployee().getId() == employeeId);

            if(checkID){
                timetrackService.saveAll(timetracks);
                return ResponseEntity.status(HttpStatus.CREATED).body("SAVES"); //cod 200
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You do not have permissions"); // cod 400
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/getWeekEmp/{id}")
    public  ResponseEntity<List<TimetrackDTO>> getWeekEmp(@PathVariable String id)  {
        LocalDate pasadoLunes = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate siguienteDomingo = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        Employee employee=this.employeeService.findById(Integer.parseInt(id));
        List<Timetrack> list=timetrackService.findTimetracksByEmployeeEqualsAndDateBetween(employee,pasadoLunes,siguienteDomingo);
        List<TimetrackDTO> dtoList = timetrackMapper.timetrackTotimetrackDto(list);
        return new ResponseEntity<List<TimetrackDTO>>(dtoList, HttpStatus.OK);
    }

}
