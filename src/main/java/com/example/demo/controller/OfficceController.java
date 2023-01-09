package com.example.demo.controller;

import com.example.demo.model.officce.OfficcesService;
import com.example.demo.model.officce.Offices;
import com.example.demo.model.officce.OfficesRepository;
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
public class OfficceController {
    @Autowired
    private OfficcesService officesService;
    @GetMapping("/oficces")
    public String index(  Model model,
                          @RequestParam(value = "page") Optional<Integer> page,
                          @RequestParam(value = "size") Optional<Integer> size){
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(5);
        //Page<Customer> customerPage=this.customerService.findAllCustomers(PageRequest.of(currentPage-1,pageSize));
      Page<Offices> officesPage=this.officesService.findAllOffices(PageRequest.of(currentPage-1,pageSize));
      model.addAttribute("officesPage",officesPage);
      int totalPages= officesPage.getTotalPages();
      if (totalPages>0){
           List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages)
                 .boxed().collect(Collectors.toList());
          model.addAttribute("pageNumbers",pageNumbers);
        }
        return "officces/index";
}

    @GetMapping("/oficces/new")
    public String index(  Model model){
        Offices office=new Offices();
        model.addAttribute("office",office);
        return "officces/newOfficce";
    }
    @PostMapping("/oficces/new")
    public String saveOffice(@ModelAttribute("office") Offices o){
        System.out.println(" name "+o.getName());
        officesService.save(o);
        return "redirect:/oficces";
    }
    @GetMapping("/deleteOficce/{id}")
    public String deleteOficce(@PathVariable(value = "id") int id){
       this.officesService.deleteById(id);
        return "redirect:/oficces";
    }
    @GetMapping("/editOffice/{id}")
    public String editOfficce(@PathVariable(value = "id") int id,Model model){
        Offices o=this.officesService.findById(id);
        model.addAttribute("office",o);
        return "officces/editOffice";

    }
    @PostMapping("/oficces/edit")
    public String editOffice(@ModelAttribute(name = "office") Offices o){
        System.out.println(" name "+o.getName()+" id "+o.getId());
        this.officesService.updateOffice(o.getName(),o.getId().intValue());
        return "redirect:/oficces";
    }
}
