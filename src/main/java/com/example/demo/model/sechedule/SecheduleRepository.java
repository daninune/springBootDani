package com.example.demo.model.sechedule;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.provinces.Provinces;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SecheduleRepository extends JpaRepository<Sechedule,Integer> {
    @Query(value = "SELECT * FROM sechedule", nativeQuery = true)
    List<Sechedule> getSechedule();
    @Query(value = "SELECT * FROM sechedule", nativeQuery = true)
    Page<Sechedule> findSechedules(Pageable pageable);
    @Query(value = "SELECT * FROM sechedule where id=:id", nativeQuery = true)
    Sechedule findSecheduleById(@Param("id") int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE sechedule SET descripcion = :descripcion, end = :end, is_complete_week = :is_complete_week, start = :start WHERE id = :id",nativeQuery = true)
    void updateSechedule(@Param("descripcion") String descripcion, @Param("end") Date end , @Param("is_complete_week") int isCompleteWeek ,@Param("start") Date start, @Param("id") Integer id);
}
