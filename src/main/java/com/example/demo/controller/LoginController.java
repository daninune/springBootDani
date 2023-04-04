package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class LoginController {

    @RequestMapping({"", "/", "/login", "/index",})
    public String getLogin() {
        return "login";
    }

    @GetMapping("/change")
    public String getAreas(Model model, @RequestParam String lang, HttpServletRequest request) {
        System.out.println(" lang " + lang + " default locale " + Locale.getDefault());

        switch (lang) {
            case "en":
                Locale.setDefault(Locale.ENGLISH);
                break;
            case "es":
                Locale.setDefault(new Locale("es", "ES"));
                break;
            case "ch":
                Locale.setDefault(Locale.CHINESE);
                break;
            default:
                Locale.setDefault(Locale.getDefault());
        }

        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }
}
