package com.ileriJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @GetMapping(value = "/home")
    public String homeView(Model model){
        List<String> list = new ArrayList<>();
        list.add("FURKAN");
        list.add("ÖZLEM");
        list.add("ALPEREN");
        list.add("CAN");
        model.addAttribute("list", list);
        return "homepage";
    }
}
