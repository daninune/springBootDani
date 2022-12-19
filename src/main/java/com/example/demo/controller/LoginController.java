package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.net.http.HttpClient;

@Controller
public class LoginController {
    private static final String SECRET_KEY_1 = "ssdkF$HUy2A#D%kd";
    private static final String SECRET_KEY_2 = "weJiSEvR5yAC5ftB";

    private IvParameterSpec ivParameterSpec;
    private SecretKeySpec secretKeySpec;
    private Cipher cipher;

    @GetMapping("/login")
    public String getIndex(Model model)
    {
        //HttpClient cli= HttpClient.newBuilder().build();
        UserDTO u =new UserDTO();
        model.addAttribute("user",u);
        return "login";

    }
@PostMapping("/login")
    public String login(@ModelAttribute("user")   UserDTO u, Model model){

        //System.out.println(" username "+u.getUsername()+" contrasena "+u.getContrast()+" encripted username "+encripted);

        if (u.getUsername().equals("admin") && u.getContrast().equals("admin")){
            return "redirect:/employees/0";
        }else {
            return "redirect:login";
        }

}

}
