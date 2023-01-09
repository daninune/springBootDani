package com.example.demo.controller;

import com.example.demo.model.officce.Offices;
import com.example.demo.model.sechedule.Sechedule;
import com.example.demo.model.sechedule.SecheduleDTO;
import com.example.demo.model.sechedule.SecheduleService;
import com.example.demo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Controller
public class SechedulesController {
@Autowired
private SecheduleService secheduleService;

public SechedulesController(SecheduleService secheduleService){
    this.secheduleService=secheduleService;
}
    @GetMapping("/Sechedules")
    public String index(Model m ,
                        @RequestParam(value = "page") Optional<Integer> page,
                        @RequestParam(value = "size") Optional<Integer> size
          ) {
        int currentPage=page.orElse(1);
        int pageSize=size.orElse(5);
        Page<Sechedule> pageSechedules=this.secheduleService.findAllSechedules(PageRequest.of(currentPage-1,pageSize));
        m.addAttribute("currentPage",pageSechedules);
        m.addAttribute("totalPages",pageSechedules.getTotalPages());
        m.addAttribute("listusr",pageSechedules.getContent());
        return "sechedules/index";
    }
    @GetMapping("/Sechedules/new")
    public String index(Model m){
    SecheduleDTO sechedule=new SecheduleDTO();
    m.addAttribute("sechedule",sechedule);
    return "sechedules/newSechedule";
    }
    @PostMapping("/Sechedules/new")
    public String saveSechedule(@ModelAttribute(name = "sechedule") SecheduleDTO sechedule){
        Sechedule scheduleEntity=new Sechedule();
System.out.println(" descripcion "+sechedule.getDescripcion()+" start "+sechedule.getStart()+" end "+sechedule.getEnd());
        scheduleEntity.setDescripcion(sechedule.getDescripcion());
        scheduleEntity.setStart(sechedule.getStart());
        scheduleEntity.setEnd(sechedule.getEnd());
        scheduleEntity.setIsCompleteWeek(0);
        secheduleService.save(scheduleEntity);
        /*PENDIENTE MIRAR QUE GUARDE BIEN FECHA/HORA
        */
        return "sechedules/index";
    }
}
