package com.example.demo.model.employee;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.officce.Offices;
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
    private int idemployee;
    private String hash;
    private Date startdate;
    private String name;
    private String lastname;
    private Date  fechaNacimiento;
    private String idcard;
   private String ssnumber;
   private  String address;
    private String zip;
    private  String city;

    @ManyToOne
    @JoinColumn(name="idprovince", nullable=false)
    private Provinces idprovince;

    private String  country;
    private String tel;
    private String email;
    private String iban;
    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Customer idcustomer;
    private String rgpd;
    private String area;
    private String job;
    private String notes;
    private  String category;
    private Date leavingdate;
    private String nip;
    private String baseline;
    private String idschedule;

    @ManyToOne
    private Offices idOffice;

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Provinces getIdprovince() {
        return idprovince;
    }

    public void setIdprovince(Provinces idprovince) {
        this.idprovince = idprovince;
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

    public Customer getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Customer idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getRgpd() {
        return rgpd;
    }

    public void setRgpd(String rgpd) {
        this.rgpd = rgpd;
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

    public Date getLeavingdate() {
        return leavingdate;
    }

    public void setLeavingdate(Date leavingdate) {
        this.leavingdate = leavingdate;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getBaseline() {
        return baseline;
    }

    public void setBaseline(String baseline) {
        this.baseline = baseline;
    }

    public String getIdschedule() {
        return idschedule;
    }

    public void setIdschedule(String idschedule) {
        this.idschedule = idschedule;
    }

    public Offices getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(Offices idOffice) {
        this.idOffice = idOffice;
    }
}