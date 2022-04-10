package com.ileriJava.controller;

import com.google.gson.Gson;
import com.ileriJava.model.FaultRecords;
import com.ileriJava.model.User;
import com.ileriJava.service.PostService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(value = "/create")
    public RedirectView createPost(@RequestParam String title, @RequestParam String context, HttpServletRequest request, HttpServletResponse response){
        postService.create(title, context, request);
        return new RedirectView("/bitirme/user/home");
    }

    @GetMapping(value = "/getByCurrentUser")
    public @ResponseBody String getByUserID(HttpServletRequest request, HttpServletResponse response){
        List<FaultRecords> recordsList = new ArrayList<>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        recordsList = postService.getByUserID(user.getUserid());
        String json = new Gson().toJson(recordsList);
        return json;
    }

    @GetMapping(value = "/detay/{faultid}")
    public String detay(@PathVariable("faultid") Long faultid, HttpServletRequest request, HttpServletResponse response, Model model){
        FaultRecords faultRecord = postService.getByID(faultid);
        model.addAttribute("faultRecord", faultRecord);
        return "post/detay";
    }

    @PostMapping(value = "/update")
    public RedirectView update(@RequestBody FaultRecords faultRecords, HttpServletRequest request, HttpServletResponse response, Model model){
        postService.update(faultRecords);
        return new RedirectView("/bitirme/post/detay/" + faultRecords.getFaultid());
    }

}
