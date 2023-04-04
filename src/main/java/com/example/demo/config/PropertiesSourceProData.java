package com.example.demo.config;

public class PropertiesSourceProData implements PropertiesSourceData {
    @Override
    public String getDriverName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/demospring";
    }

    @Override
    public String getUsername() {
        return "root";
    }
}