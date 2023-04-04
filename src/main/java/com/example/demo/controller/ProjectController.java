package com.example.demo.controller;


import com.example.demo.dto.ProjectDTO;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/project"})
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMapper projectMapper;

    @GetMapping({"","/"})
   // @PreAuthorize("hasPermission('READ')")
    public String projectList(Model model){
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("newProject", new ProjectDTO());
        return "views/project/project";
    }

    @PostMapping("/submit")
    public String submitFrom (Model model, @ModelAttribute ProjectDTO newProject) {
        System.out.println(newProject.toString());
        try {
            projectService.save(projectMapper.toEntity(newProject));
            System.out.println("guardado");
        }catch (Exception e){
            System.out.println("error");
        }
        return "redirect:/project";
    }
    @GetMapping("delete")
    public String shoeDelete(@RequestParam Integer id){
        try {
            projectService.delete(id);
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/project";
    }
}
