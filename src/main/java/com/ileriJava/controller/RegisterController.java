package com.ileriJava.controller;

import com.ileriJava.model.UserAlpi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping({"/", ""})
    public String register(){
        return "register";
    }

    @PostMapping({"/registered"})
    public String registered(@ModelAttribute UserAlpi userAlpi)
    {
        userAlpi.setSistemrol("USER");
//      user.setSifre(new BCryptPasswordEncoder().encode(user.getSifre()));
        return "login";
    }
}
