package com.example.demo.controller;

import com.example.demo.model.provinces.ProvinceService;
import com.example.demo.model.provinces.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class apiController {
@Autowired
    private ProvinceService provinceService;


    @RequestMapping(value = "/provincias", method = RequestMethod.GET)
    public List<Provinces> getProvincias(){
        List<Provinces> list=provinceService.getProvinces();
        for (Provinces p:list) {
            System.out.println("id "+p.getIdProvinces()+" name "+p.getName());
        }
        return  provinceService.getProvinces();
    }
}
