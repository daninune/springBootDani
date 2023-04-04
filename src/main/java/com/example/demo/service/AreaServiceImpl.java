package com.example.demo.service;

import com.example.demo.model.Area;
import com.example.demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;


    public List<Area> findAllAreas() {
        return areaRepository.findAll();
    }


    @Override
    public void deleteById(int idArea) {
        areaRepository.deleteById(idArea);
    }

    @Override
    public void saveArea(Area a) {
        areaRepository.save(a);
    }

    @Override
    public Area findAreaById(int idArea) {
        return areaRepository.findById(idArea).orElse(null);
    }

    @Override
    public List<Area> findAreaByName(String nombre) {
        return areaRepository.findAreaByNombre(nombre);
    }


}
