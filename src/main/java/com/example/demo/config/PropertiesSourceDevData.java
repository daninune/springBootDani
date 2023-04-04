package com.example.demo.config;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class PropertiesSourceDevData implements PropertiesSourceData {
    @Override
    public String getDriverName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/demospringdev";
    }


    @Override
    public String getUsername() {
        return "root";
    }
}