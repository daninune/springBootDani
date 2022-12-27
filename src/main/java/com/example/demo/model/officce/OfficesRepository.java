package com.example.demo.model.officce;

import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficesRepository extends JpaRepository<Offices,Integer> {

    @Query(value = "SELECT * FROM offices", nativeQuery = true)
    List<Offices> getOffices();
    @Query(value = "update offices set name=:name where idOffice=:idOffice",nativeQuery = true)
    boolean updateOffice(@Param("name") String name, @Param("idOffice") int id);
    @Query(value = "SELECT * FROM offices", nativeQuery = true)
    Page<Offices> findAllOffices(Pageable pageable);
    @Query(value = "SELECT * FROM offices where idOffice=:idOffice", nativeQuery = true)
    Offices findOfficesById(@Param("idOffice") int id);
}
