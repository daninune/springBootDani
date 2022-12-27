package com.example.demo.model.paises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PaisService implements PaisDAO{
    @Autowired
    private PaisRepository paisRepository;

    public  PaisService(PaisRepository paisRepository) {
        this.paisRepository=paisRepository;
    }

    @Override
    public List<Paises> getPaises() {
        return paisRepository.getPaises();
    }
}
