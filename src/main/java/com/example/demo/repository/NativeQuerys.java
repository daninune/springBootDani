package com.example.demo.repository;

import com.example.demo.model.Area;

import java.util.List;

public interface NativeQuerys {

    List<Area> findByUser();
}
