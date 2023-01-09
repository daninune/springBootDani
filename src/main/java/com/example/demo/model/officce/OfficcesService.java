package com.example.demo.model.officce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OfficcesService implements OfficesDAO{

    @Autowired
    private OfficesRepository officesRepository;

    public OfficcesService(OfficesRepository officesRepository) {
        this.officesRepository = officesRepository;
    }

    @Override
    public List<Offices> getOffices() {
        return officesRepository.getOffices();
    }

    @Override
    public Offices findById(Integer id) {
        return officesRepository.findOfficesById(id.intValue());
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
    public void deleteById(Integer id) {
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

    @Override
    public void updateOffice(String name, int id) {
       this.officesRepository.updateOffice(name,id);
    }
}
