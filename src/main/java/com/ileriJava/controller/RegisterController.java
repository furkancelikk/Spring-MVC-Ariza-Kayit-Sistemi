package com.ileriJava.controller;

import com.ileriJava.model.User;
import com.ileriJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", ""})
    public String register(){
        return "register";
    }

    @PostMapping({"/registered"})
    public RedirectView registered(@RequestParam String kullaniciadi, @RequestParam String ad,
                                   @RequestParam String soyad, @RequestParam String email, @RequestParam String sifre)
    {
        User user = new User();
        user.setKullaniciadi(kullaniciadi);
        user.setAd(ad);
        user.setSoyad(soyad);
        user.setSifre(sifre);
        user.setEmail(email);
        user.setSistemrol("USER");
        userService.addUser(user);
//        if (userService.addUser(user) != null)
//            System.out.println("USER KAYDEDİLDİ");
//        else
//            System.out.println("HATA");
        return new RedirectView("/bitirme/login");
    }
}
