package com.example.demo.repository;

import com.example.demo.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AreaRepository extends JpaRepository <Area, Integer> {
    List<Area> findAreaByNombre(String nombre);
}