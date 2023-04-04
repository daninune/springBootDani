package com.example.demo.controller;

import com.example.demo.dto.EditProfileDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/main/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;
    
    @GetMapping("/employeedata")
    public String getEmployeeView(UserDetailsImpl userId, Model model) {

        UserDetailsImpl logged = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Employee employee = employeeService.findById(logged.getId());
        System.out.println(employeeMapper.toEditProfileDTO(employee));
        model.addAttribute("editProfile", employeeMapper.toEditProfileDTO(employee));

        if (logged.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            model.addAttribute("isDisabled", false);
            return "/views/employees/employee";
        }
        model.addAttribute("isDisabled", true);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        String name = authentication.getName();
//        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
//        String email = principal.getEmail();
//
//        model.addAttribute("name", name);
//        model.addAttribute("email", email);

        return "/views/employees/employee";
    }

    @PostMapping ("/employeedata")
    public String submitProfile(@ModelAttribute("editProfile") @Valid EditProfileDTO employee, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){
            System.out.println(employee);
            System.out.println("---------- Validation error in the fields --------------");
            List<String> errorMessages = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .toList();
            System.out.println("Errores de validación: " + errorMessages);
            return "views/employees/employee";
        }

        UserDetailsImpl logged = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(employee );
        if (logged.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            try{
                employeeService.save(employeeMapper.toEntity(employee, logged.getId()));
                System.out.println("update employee");
                return "redirect:/main/employee/employeedata";
            }catch (Exception e){
                System.out.println(e);
                return "redirect:/main/employee/employeedata";
            }
        }
        try{
            employeeService.savePartial(employeeMapper.toEntity(employee, logged.getId()));
            System.out.println("update employee");
            return "redirect:/main/employee/employeedata";
        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/main/employee/employeedata";
    }
}
