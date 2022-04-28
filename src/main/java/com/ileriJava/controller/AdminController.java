package com.ileriJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/*")
public class AdminController {

    @GetMapping(value = "/home")
    public String adminHome(){
        return "adminhome";
    }

    @GetMapping(value = "/kategori")
    public String kategoriIslemleri(){
        return "category/addCategory";
    }


}
