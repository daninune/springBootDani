package com.example.demo.model.officce;

import jakarta.persistence.*;

@Entity
public class Offices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id")
    private Integer id;
    @Column(name = "office")
    private String office;

    public Integer getId() {
        return id;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOffice() {
        return office;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
