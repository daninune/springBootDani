package com.example.demo.model.provinces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Provinces, Integer> {
    @Query(value = "SELECT * FROM provinces", nativeQuery = true)
    List<Provinces> getProvinces();
}
