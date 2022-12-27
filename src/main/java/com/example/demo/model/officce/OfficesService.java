package com.example.demo.model.officce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficesService implements OfficesDAO {
    @Autowired
    private OfficesRepository officesRepository;

    public OfficesService(OfficesRepository officesRepositor){
        this.officesRepository=officesRepositor;
    }
    @Override
    public List<Offices> getOffices() {
        return officesRepository.getOffices();
    }

    @Override
    public Offices findById(int id) {
        return officesRepository.findOfficesById(id);
    }

    @Override
    public Iterable<Offices> findAll(Pageable pageable) {
        return officesRepository.findAllOffices(pageable);
    }

    @Override
    public void save(Offices office) {
              officesRepository.save(office);
    }

    @Override
    public void deleteById(int id) {
         officesRepository.deleteById(id);
    }

    @Override
    public Page<Offices> findAllOffices(Pageable pageable) {
        return officesRepository.findAllOffices(pageable);
    }

    @Override
    public long count() {
        return 0;
    }
}
