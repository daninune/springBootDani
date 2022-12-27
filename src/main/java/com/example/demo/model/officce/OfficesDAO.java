package com.example.demo.model.officce;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfficesDAO {


    List<Offices> getOffices();

    Offices findById(int id);

    Iterable<Offices> findAll(Pageable pageable);

    void save(Offices office);

    void deleteById(int id);
    Page<Offices> findAllOffices(Pageable pageable);

    long count();
}
