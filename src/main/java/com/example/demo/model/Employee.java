package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;



@Data
@Entity
@Table(name = "employees")
public class Employee {
    private static final String SEQUENCE = "SEQ_M_ASOCIACIONES"; //funcion que genera los ids en bd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "startdate", columnDefinition = "date")
    private String startdate;
    @Column(name = "name", columnDefinition = "varchar(45)")
    private String name;
    @Column(name = "lastname", columnDefinition = "varchar(45)")
    private String lastname;
    @Column(name = "fechaNacimiento", columnDefinition = "date")
    private String fechaNacimiento;
    @Column(name = "idcard", columnDefinition = "varchar(45)")
    private String idcard;
    @Column(name = "ssnumber", columnDefinition = "varchar(45)")
    private String ssnumber;
    @Column(name = "address", columnDefinition = "varchar(45)")
    private String address;
    @Column(name = "zip", columnDefinition = "varchar(45)")
    private String zip;
    @Column(name = "city", columnDefinition = "varchar(45)")
    private String city;
    @Column(name = "idprovince", columnDefinition = "int")
    private Integer idprovince;
    @Column(name = "country", columnDefinition = "varchar(45)")
    private String country;
    @Column(name = "tel", columnDefinition = "varchar(45)")
    private String tel;
    private String email;
    @Column(name = "iban", columnDefinition = "varchar(45)")
    private String iban;
    @Column(name = "idcustomer", columnDefinition = "int")
    private Integer idcustomer;
    @Column(name = "isdelete", columnDefinition = "int")
    private Integer isdelete;
    @Column(name = "pass", columnDefinition = "varchar(45)")
    private String pass;
    @Column(name = "rgpd", columnDefinition = "varchar(45)")
    private String rgpd;
    @Column(name = "idrol", columnDefinition = "int")
    private Integer idrol;
    @Column(name = "passreset", columnDefinition = "varchar(45)")
    private String passreset;
    @Column(name = "passresetdate", columnDefinition = "date")
    private java.util.Date passresetdate;
    @Column(name = "area", columnDefinition = "varchar(200)")
    private String area;
    @Column(name = "job", columnDefinition = "varchar(200)")
    private String job;
    @Column(name = "notes", columnDefinition = "varchar(500)")
    private String notes;
    @Column(name = "category", columnDefinition = "varchar(45)")
    private String category;
    @Column(name = "loginretries", columnDefinition = "int")
    private Integer loginretries;
    @Column(name = "creationdate", columnDefinition = "date")
    private java.util.Date creationdate;
    @Column(name = "firstlogin", columnDefinition = "int")
    private Integer firstlogin;
    @Column(name = "leavingdate", columnDefinition = "date")
    private String leavingdate;
    @Column(name = "nip", columnDefinition = "varchar(10)")
    private String nip;
    @Column(name = "baseline", columnDefinition = "varchar(100)")
    private String baseline;
    @Column(name = "idschedule", columnDefinition = "int")
    private Integer idschedule;
    @Column(name = "idOffice", columnDefinition = "int")
    private Integer idoffice;
    @Column(name = "alreadyVoted", columnDefinition = "int")
    private Integer alreadyVoted;
    @Column(name = "vacationLimit", columnDefinition = "varchar(255)")
    private String vacationLimit;


}
