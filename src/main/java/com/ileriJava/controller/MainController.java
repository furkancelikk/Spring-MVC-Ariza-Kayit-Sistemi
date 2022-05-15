package com.ileriJava.controller;

import com.ileriJava.enums.UserRole;
import com.ileriJava.model.User;
import com.ileriJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MainController {




    @RequestMapping({"", "/"})
    public String main(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String redirect = "/bitirme/";

        if (user.getRole() == UserRole.USER){
            redirect += "user/home";
        }else if (user.getRole() == UserRole.ADMIN){
            redirect += "admin/home";
        }else if (user.getRole() == UserRole.PERSONNEL){
            redirect += "personel/home";
        }

        try {
            response.sendRedirect(redirect);
        }catch (Exception e){
            return "errors/404";
        }

        return "index";
    }


}
