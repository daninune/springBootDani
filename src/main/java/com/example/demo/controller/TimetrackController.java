package com.example.demo.controller;

import com.example.demo.dto.TimetrackDTO;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.model.Timetrack;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.model.enumerated.Workplaces;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TimetrackServiceImpl;
import com.example.demo.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@Controller
@RequestMapping("/timetrack")
public class TimetrackController {
    @Autowired
    private TimetrackServiceImpl timetrackService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private EmployeeServiceImpl employeeService;


    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping({"", "/", "/index"})
    //@PreAuthorize("hasAuthority('WRITE')")
    public String getTimetrack(Model model) {
        model.addAttribute("timetrack", new Timetrack());

        ArrayList<Project> proyectos = new ArrayList<Project>(projectService.findAll());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();

        model.addAttribute("proyectos", proyectos);
        model.addAttribute("today", dateFormat.format(today));
        return "views/timetrack/index";
    }

    @PostMapping("createTimetrack")
    public String crearTimetrack(@ModelAttribute("timetrack") TimetrackDTO timetrackModelDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();

        Integer currentUserId = principal.getId();
        Employee employee = employeeService.findById(currentUserId);
        Project project = projectService.findProjectById(timetrackModelDTO.getProject());
        Workplaces workplace = Workplaces.valueOf(timetrackModelDTO.getWorkplace().toUpperCase());

        Timetrack timetrack = new Timetrack();
        timetrack.setEmployee(employee);
        timetrack.setProject(project);
        timetrack.setWorkplace(workplace);
        timetrackService.save(timetrack);

        return "redirect:/timetrack/index";
    }
}
