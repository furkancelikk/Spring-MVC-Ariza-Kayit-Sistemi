package com.ileriJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping({"/", ""})
    public String main(){
        // Burada kullanıcı var ise anasayfaya yok ise logine yönlendirilecek
        return "homepage";
    }

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
