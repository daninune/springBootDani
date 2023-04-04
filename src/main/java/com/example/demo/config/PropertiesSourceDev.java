package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@AutoConfiguration
public class PropertiesSourceDev implements PropertiesSource {

    PropertiesSourceData nuestroSourcedata = new PropertiesSourceDevData();


    private final String url = nuestroSourcedata.getUrl();

    @Override
    public String getUrl() {
        return url;
    }
}