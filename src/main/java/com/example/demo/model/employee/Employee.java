package com.example.demo.model.employee;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.provinces.Provinces;
import jakarta.persistence.*;

import java.util.Date;
/*
*
* */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Integer id;

    private String name;

    private String lastname;

    private Date fechaNacimiento;

    private  String idcard;

    private String ssnumber;

    private String address;
    private  String zip;



    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Provinces.class)
    @JoinColumn(name="id_province_id")
    private Provinces idProvince;

    private String country;
    private String tel;
    private String email;

    private String iban;
@ManyToOne(cascade = CascadeType.ALL ,targetEntity = Customer.class)
    private  Customer idCustomer;

    private  int isDelete;

    private  String area;
    private String job;
    private String notes;

    private String category;

    private Date startDate;




    public Employee() {
    }



    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSsnumber() {
        return ssnumber;
    }

    public void setSsnumber(String ssnumber) {
        this.ssnumber = ssnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Provinces getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Provinces idProvince) {
        this.idProvince = idProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}