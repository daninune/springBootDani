package com.example.demo.service;

import com.example.demo.model.Area;
import com.example.demo.model.Employee;

import java.util.List;

public interface AreaService {
    List<Area> findAllAreas();
    void deleteById(int idArea);

    void  saveArea(Area a);
    Area findAreaById(int idArea);
    List<Area> findAreaByName(String nombre);
}
