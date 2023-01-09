package com.example.demo.model.sechedule;

import jakarta.persistence.Column;

import java.util.Date;

public class SecheduleDTO {

    private String descripcion;
    private String start;
    private String end;
    private int isCompleteWeek;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getIsCompleteWeek() {
        return isCompleteWeek;
    }

    public void setIsCompleteWeek(int isCompleteWeek) {
        this.isCompleteWeek = isCompleteWeek;
    }
}
