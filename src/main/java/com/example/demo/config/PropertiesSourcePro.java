package com.example.demo.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Profile;

@AutoConfiguration
@Profile("pro")
public class PropertiesSourcePro implements PropertiesSource {
    PropertiesSourceData nuestroSourcedata = new PropertiesSourceProData();
    private String url;

    @Override
    public String getUrl() {
        return url;
    }
}