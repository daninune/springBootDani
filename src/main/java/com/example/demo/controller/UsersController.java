package com.example.demo.controller;

import com.example.demo.model.user.User;

import com.example.demo.model.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    @Autowired
    UserService userService;
    @GetMapping("/users/{pageNo}")
    public String index(Model m ,
        @RequestParam(value = "pageNo" , required = false,defaultValue ="5") int pageNo
            ) {
         int pageSize=5;
          Page<User> pageUsers=userService.findPaginated(pageNo,pageSize);
           m.addAttribute("currentPage",pageNo);
           m.addAttribute("totalPages",pageUsers.getTotalPages());
           m.addAttribute("listusr",pageUsers.getContent());
        return "users";
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
     //   System.out.println("user name "+u.getUsername()+" pass "+u.getContrast());
        return "redirect:/users/0";
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
