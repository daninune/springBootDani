package com.example.demo.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Data
@NoArgsConstructor
public class TimetrackDTO extends GeneralDTO {


    private int id;

    @NotNull(message = "#{valid.notBlank}")
    @Min(1)
    private int employee;

    @NotNull(message = "#{valid.notBlank}")
    private int project;

    @Size(max = 200,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\d\\s\\p{L}.,:-]*$", message = "#{valid.pattern}")
    private String description;

    @Size(max = 50,  message = "#{valid.size}")
    @Pattern(regexp = "^[a-zA-Z\\d\\s\\p{L}-]*$", message = "#{valid.pattern}")
    private String workplace;

    private Boolean isExtra;

    @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?$")
    private String startTime;

    @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?$")
    private String endTime;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String date;

    //@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d{3})?$")
    private String dayAdded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Boolean getExtra() {
        return isExtra;
    }

    public void setExtra(Boolean extra) {
        isExtra = extra;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayAdded() {
        return dayAdded;
    }

    public void setDayAdded(String dayAdded) {
        this.dayAdded = dayAdded;
    }
}
