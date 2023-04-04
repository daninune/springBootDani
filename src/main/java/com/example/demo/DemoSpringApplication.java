package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.model.Timetrack;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TimetrackService;
import com.example.demo.service.TimetrackServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class DemoSpringApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);

    }


}