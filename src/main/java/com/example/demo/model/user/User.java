package com.example.demo.model.user;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "contrast")
    private String contrast;

    public String getUsername(){
        return username;
    }
    public  void setUsername(String  username){

        this.username=username;
    }
    public String getContrast(){
        return contrast;
    }
    public void setContrast(String contrast){
        this.contrast=utils.Security.encrypt(contrast);
    }

}
