package com.example.demo.model.sechedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SecheduleService implements SecheduleDAO{

@Autowired
private SecheduleRepository secheduleRepository;
public SecheduleService(SecheduleRepository secheduleRepository){
    this.secheduleRepository=secheduleRepository;
}
    @Override
    public List<Sechedule> getSechedules() {
        return secheduleRepository.getSechedule();
    }

    @Override
    public Sechedule findById(Integer idSechedule) {
        return secheduleRepository.findSecheduleById(idSechedule.intValue());
    }

    @Override
    public Iterable<Sechedule> findAll(Pageable pageable) {
        return secheduleRepository.findSechedules(pageable);
    }

    @Override
    public void save(Sechedule sechedule) {
          this.secheduleRepository.save(sechedule);
    }

    @Override
    public Page<Sechedule> findAllSechedules(Pageable pageable) {
        return this.secheduleRepository.findSechedules(pageable);
    }


    @Override
    public void deleteById(int id) {
        Sechedule sechedule=this.secheduleRepository.findSecheduleById(id);
        this.secheduleRepository.delete(sechedule);
    }

    @Override
    public void updateSechedule(String descripcion, Date end, int isCompleteWeek, Date start, Integer id) {
           this.secheduleRepository.updateSechedule(descripcion,end,isCompleteWeek,start,id);
    }
}
