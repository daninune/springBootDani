package com.example.demo.model.paises;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Paises,Integer> {
    @Query(value = "SELECT * FROM paises", nativeQuery = true)
    List<Paises>  getPaises();
}
