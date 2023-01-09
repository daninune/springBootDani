package com.example.demo.model.customer;

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
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer ", nativeQuery = true)
    List<Customer> getAll();
    @Query(value = "SELECT * FROM customer", nativeQuery = true)
    Page<Customer> findCustomers(Pageable pageable);
    @Query(value = "SELECT * FROM customer where id=:id", nativeQuery = true)
    Customer findCustomerById(@Param("id") int id);

     @Modifying
     @Transactional
     @Query(value = "UPDATE customer SET name =:name WHERE id = :id",nativeQuery = true)
    void updateCustomer(@Param("name") String name, @Param("id") Integer id);
}
