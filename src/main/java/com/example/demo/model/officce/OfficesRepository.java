package com.example.demo.model.officce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OfficesRepository extends JpaRepository<Offices,Integer> {
    @Query(value = "SELECT * FROM offices", nativeQuery = true)
    List<Offices> getOffices();
    @Modifying
    @Transactional
    @Query(value = "update offices set name=:name where id=:id",nativeQuery = true)
    void updateOffice(@Param("name") String name, @Param("id") int id);
    @Query(value = "SELECT * FROM offices", nativeQuery = true)
    Page<Offices> findAllOffices(Pageable pageable);
    @Query(value = "SELECT * FROM offices where id=:id", nativeQuery = true)
    Offices findOfficesById(@Param("id") int id);
}
