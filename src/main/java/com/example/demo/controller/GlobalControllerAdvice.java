package com.example.demo.controller;

import com.example.demo.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("name")
    public String getName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @ModelAttribute("permissions")
    public List<String> getPermissions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
            return principal.getPermissions().stream().map(GrantedAuthority::toString).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @ModelAttribute("authorities")
    public List<String> getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
            return principal.getAuthorities().stream().map(GrantedAuthority::toString).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}