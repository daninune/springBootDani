package com.example.demo.controller;

import com.example.demo.model.Area;
import com.example.demo.model.User;
import com.example.demo.service.AreaServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main/dev")
public class DevController {

    @Autowired
    AreaServiceImpl areaServiceImpl;

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<User> users = userServiceImpl.findAllUsers();
        model.addAttribute("users", users);

        return "/views/dev/users";
    }

    @GetMapping("/tabla")
    public String getTable(Model model) {
        ArrayList<String> listacampos = new ArrayList<String>();
        List<Area> areas = this.areaServiceImpl.findAllAreas();
        Area a = new Area();
        ArrayList<String> cabeceras = a.getCabeceras(a);
        ArrayList mostrarDani = new ArrayList<Object>();
        mostrarDani.add(new Area(null, "segundo"));
        mostrarDani.add(new Area(4, "tercero"));
        mostrarDani.add(new Area(5, "cuarto"));
        mostrarDani.add(new Area(6, "quinto"));
        mostrarDani.add(new Area(7, "sexto"));
        mostrarDani.add(new Area(8, "septimo"));
        mostrarDani.add(new Area(9, "octavo"));
        mostrarDani.add(new Area(10, "noveno "));
        model.addAttribute("listacampos", listacampos);
        model.addAttribute("lista", mostrarDani);
        model.addAttribute("cabezeras", cabeceras);

        return "/views/dev/testTabla";
    }

    /**
     * PERMISSIONS
     **/
    @GetMapping({"/permission", "/permission/", "/permission/index"})
    @PreAuthorize("hasPermission('READ')")
    public String getIndex() {
        return "/views/dev/permission/index";
    }

    // everyone (filtered before) with READ permission can read
    @GetMapping("/permission/vacation-read")
    @PreAuthorize("hasAllPermission('READ','ONLY_RRHH_VACATION')")
    public String getVacationRead() {
        return "/views/dev/permission/vacation-read";
    }

    // Manager with permission vacation
    @GetMapping("/permission/vacation-create")
    @PreAuthorize("hasAllPermission('CREATE','ONLY_RRHH_VACATION')")
    public String getVacationCreate() {
        return "/views/dev/permission/vacation-create";
    }

    // Consultant or manager with permission vacation historic
    @GetMapping("/permission/vacation-historical-read")
    @PreAuthorize("hasAllPermission('READ','ONLY_RRHH_VACATION_HISTORICAL')")
    public String getVacationHistoricRead() {
        return "/views/dev/permission/vacation-historic-read";
    }

    // Manager with permission vacation historic
    @GetMapping("/permission/vacation-historical-create")
    @PreAuthorize("hasAllPermission('CREATE','ONLY_RRHH_VACATION_HISTORICAL')")
    public String getVacationHistoricCreate() {
        return "/views/dev/permission/vacation-historic-create";
    }

}
