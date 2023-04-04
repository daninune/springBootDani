package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/main/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/editUserModal/{id}")
    @PreAuthorize("isLoggedUser(#id)")
    public String getEditUserModal(@PathVariable Integer id, Model model) {
        User user = userService.findUserById(id);
        if (user != null) {
            model.addAttribute("User", user);
        }
        return "/views/user/editUserModal";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User newUserData) {
        User user = userService.findUserById(newUserData.getId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.setUsername(newUserData.getUsername());
        user.setEmail(newUserData.getEmail());
        user.setRoles(newUserData.getRoles());
        userService.saveUser(user);

        return "redirect:/main/index";
    }
}
