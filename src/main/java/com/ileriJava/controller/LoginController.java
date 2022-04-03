package com.ileriJava.controller;

import com.ileriJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    UserService userService;

    @GetMapping()
    public String login(){
        return "login";
    }

    @PostMapping
    public String isExist(@RequestParam String email, @RequestParam String password, Model model){
//        Boolean isExist = userService.isExist(email, password);
        Boolean isExist = email.indexOf("furkan") > -1 ? true : false;
        if (isExist){
            return "homepage";
        }
        return "login";
    }

}
