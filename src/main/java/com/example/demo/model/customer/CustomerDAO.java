package com.example.demo.model.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    Customer findById(Integer idCustomer);

    Iterable<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Page<Customer> findAllCustomers(Pageable pageable);
    void deleteById(int id);

    void updateCustomer(String name,  Integer id);
}
