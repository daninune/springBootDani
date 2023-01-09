package com.example.demo.model.officce;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfficesDAO {

    List<Offices> getOffices();

    Offices findById(Integer id);

    Iterable<Offices> findAll(Pageable pageable);

    void save(Offices office);

    void deleteById(Integer id);
    Page<Offices> findAllOffices(Pageable pageable);

    long count();
    void updateOffice(String name,  int id);
}
