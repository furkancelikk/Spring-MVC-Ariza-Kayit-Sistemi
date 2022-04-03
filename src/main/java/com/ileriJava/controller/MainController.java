package com.ileriJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MainController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping({"/", ""})
    public String main(){
        // Burada kullanıcı var ise anasayfaya yok ise logine yönlendirilecek
        return "homepage";
    }

    @GetMapping(value = "/home")
    public String homeView(Model model, Locale locale, HttpServletRequest request, HttpServletResponse response){
        List<String> list = new ArrayList<>();
        list.add("FURKAN");
        list.add("ÖZLEM");
        list.add("ALPEREN");
        list.add("CAN");
        model.addAttribute("list", list);

        model.addAttribute("karsilama",
                messageSource.getMessage("karsilama", null, locale));

        model.addAttribute("kisiKarsilama",
                messageSource.getMessage("kisiKarsilama", new Object[] {"Furkan"},
                        locale));

        model.addAttribute("locale", locale);

        return "homepage";
    }
}
