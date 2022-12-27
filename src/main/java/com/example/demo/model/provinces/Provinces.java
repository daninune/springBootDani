package com.example.demo.model.provinces;

import jakarta.persistence.*;

@Entity
public class Provinces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")

    private Integer idProvinces;

    private String name;

    public Integer getIdProvinces() {
        return idProvinces;
    }

    public void setIdProvinces(Integer idProvinces) {
        this.idProvinces=idProvinces;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
