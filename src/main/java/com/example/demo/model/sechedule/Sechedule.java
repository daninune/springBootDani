package com.example.demo.model.sechedule;

import jakarta.persistence.*;

import java.sql.Time;


@Entity
public class Sechedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private int id;
    @Column
    private String descripcion;
    @Column
    private String start;
    @Column
    private String end;
    @Column
    private int isCompleteWeek;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
