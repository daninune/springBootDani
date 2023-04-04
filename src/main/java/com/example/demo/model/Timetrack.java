package com.example.demo.model;


import com.example.demo.model.enumerated.Workplaces;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
//@Data
public class Timetrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", columnDefinition = "date")
    private LocalDate date;

    @Column(length = 80)
    private String description;

    @Column(name = "end_time", columnDefinition = "time")
    private LocalTime endTime;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "start_time", columnDefinition = "time")
    private LocalTime startTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private Boolean isExtra;

    //  @Column(name = "workplace")
    @Enumerated(EnumType.STRING)
    private Workplaces workplace;

    @CreationTimestamp
    @Column(name = "dayAdded", updatable = false, nullable = false)
    private LocalDateTime dayAdded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Boolean getExtra() {
        return isExtra;
    }

    public void setExtra(Boolean extra) {
        isExtra = extra;
    }

    public Workplaces getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplaces workplace) {
        this.workplace = workplace;
    }

    public LocalDateTime getDayAdded() {
        return dayAdded;
    }

    public void setDayAdded(LocalDateTime dayAdded) {
        this.dayAdded = dayAdded;
    }
}
