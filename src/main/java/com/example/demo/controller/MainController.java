package com.example.demo.controller;

import com.example.demo.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = authentication.getName();
        String role = authentication.getAuthorities().toString();
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();

        Integer id = principal.getId();
        String permission = principal.getPermissions().toString();
        String email = principal.getEmail();
        String sessionId = details == null ? null : details.getSessionId();

        model.addAttribute("name", name);
        model.addAttribute("id", id);
        model.addAttribute("email", email);
        model.addAttribute("role", role);
        model.addAttribute("permission", permission);
        model.addAttribute("sessionId", sessionId);

        return "/views/index/newIndex";
    }

    @GetMapping("/admin")
    @Secured({"ROLE_MODERATOR"})
    public String principal(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        model.addAttribute("name", name);

        return "/views/admin";
    }
}
