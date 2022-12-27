package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerRepository;
import com.example.demo.model.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class customerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String index(  Model model,
                          @RequestParam(value = "page") Optional<Integer> page,
                          @RequestParam(value = "size") Optional<Integer> size){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(5);
        Page<Customer> customerPage=this.customerService.findAllCustomers(PageRequest.of(currentPage-1,pageSize));
        model.addAttribute("customerPage",customerPage);
        int totalPages= customerPage.getTotalPages();
        if (totalPages>0){
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages)
                    .boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        return "customer/index";
   }
   @GetMapping("/customers/newCustomer")
    public String newCustomer(Model m){
       Customer customer=new Customer();
       m.addAttribute("customer",customer);
        return "customer/newCustomer";
   }
   @PostMapping("/customers/new")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        System.out.println(" ==> "+customer.getName());
        customerService.save(customer);
       return "redirect:/customers";
   }
    @GetMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
        customerService.deleteById(id);
        return "redirect:/customers";
    }
    @GetMapping("/editCustomer/{id}")
    public String editCustomer(@PathVariable(value = "id") int id,Model m ){
        Customer customer= customerService.findById(id);
        m.addAttribute("customer",customer);
        return "customer/editCustomer";
    }
    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute("customer") Customer c,Model m){
        System.out.println(" id "+c.getId()+" name "+c.getName());
        customerService.updateCustomer(c.getName(),c.getId());
        return "redirect:/customers";
    }
}
