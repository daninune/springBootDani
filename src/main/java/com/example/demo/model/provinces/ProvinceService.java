package com.example.demo.model.provinces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements  ProvinceDAO {
    /*@Autowired
    private  ProvinceRepository provinceRepository;*/
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Provinces> getProvinces() {
        List<Provinces> listaProvincias= jdbcTemplate.query("select * from provinces", BeanPropertyRowMapper.newInstance(Provinces.class));
        return listaProvincias;
    }
}
