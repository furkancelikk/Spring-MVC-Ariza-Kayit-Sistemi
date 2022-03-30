package com.ileriJava.controller;

import com.ileriJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping({"/", ""})
    public String login(){
        return "login";
    }

    @PostMapping
    public RedirectView isExist(@RequestParam String username, @RequestParam String password){
        Boolean isExist = userService.isExist(username, password);
        if (isExist){
            return new RedirectView("/bitirme");
        }
        return new RedirectView("/bitirme/login");
    }

}
