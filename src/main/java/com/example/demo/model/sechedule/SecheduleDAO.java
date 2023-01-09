package com.example.demo.model.sechedule;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SecheduleDAO {

    List<Sechedule> getSechedules();
    Sechedule findById(Integer idSechedule);

    Iterable<Sechedule> findAll(Pageable pageable);

    void save(Sechedule sechedule);

    Page<Sechedule> findAllSechedules(Pageable pageable);
    void deleteById(int id);

    void updateSechedule(String descripcion, Date end ,  int isCompleteWeek , Date start, Integer id);
}
