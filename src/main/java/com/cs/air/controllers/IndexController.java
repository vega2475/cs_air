package com.cs.air.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = false;
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_USER")) {
                isAuthenticated = true;
                break;
            }
        }
        model.addAttribute("isAuthenticated", isAuthenticated);
        return "/index";
    }
    @GetMapping("/pricing")
    public String pricing(){
        return "pricing";
    }
}
