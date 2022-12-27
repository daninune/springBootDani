package com.example.demo.model.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements  CustomerDAO{
    @Autowired
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public Customer findById(Integer idCustomer) {
        return customerRepository.findCustomerById(idCustomer);
    }

    @Override
    public Iterable<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Customer customer) {
           customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllCustomers(Pageable pageable) {
        return customerRepository.findCustomers(pageable);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(String name, Integer idCustomer) {
         customerRepository.updateCustomer(name,idCustomer);
    }
}
