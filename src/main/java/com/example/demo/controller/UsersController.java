package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.user.User;

import com.example.demo.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String index(Model m ,
                        @RequestParam(value="page",required = false,defaultValue = "1") int page,
                        @RequestParam(value = "size" , required = false,defaultValue ="5") int size,Pageable pageable)
     {
      //  List<User> user=userService.GetAllUsers();
         //Page<User> pageUsers=userService.findAllUsers();
      /*
       m.addAttribute("users",pageUsers.getContent());
       m.addAttribute("pages",pageUsers.getTotalPages());
       m.addAttribute("currentpage",page);
      */  return "users";
    }//newUser
    @GetMapping("/users/new")
    public String newUser(Model m ){
        User u=new User();
        m.addAttribute("user",u);
        return  "newUser";
    }
    @PostMapping("/users/new")
    public String saveUser(@ModelAttribute("User") User u){
        userService.save(u);
        System.out.println("user name "+u.getUsername()+" pass "+u.getContrast());
        return "redirect:/users";
    }
    @GetMapping("/edit/{username}")
    public String editEmployee(@PathVariable(value = "username") String username, Model model) {
        System.out.println(" id "+username);
        // call delete employee method1
        //User u=userService.findByUsername(username);
         //model.addAttribute("user",u);
        return "editUser";
    }

}
