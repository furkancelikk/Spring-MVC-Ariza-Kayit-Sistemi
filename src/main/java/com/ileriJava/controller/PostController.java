package com.ileriJava.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ileriJava.enums.UserRole;
import com.ileriJava.model.FaultRecords;
import com.ileriJava.model.User;
import com.ileriJava.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/post/*")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(value = "/create")
    public @ResponseBody String createPost(@RequestParam String title, @RequestParam String context, @RequestParam Long categoryID, HttpServletRequest request, HttpServletResponse response){
        FaultRecords faultRecord = postService.create(title, context, categoryID, request);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", faultRecord);
        String json = gson.toJson(map);
        return json;
    }

    @GetMapping(value = "/getByCurrentUser")
    public @ResponseBody String getByUserID(HttpServletRequest request, HttpServletResponse response){
        List<FaultRecords> recordsList = new ArrayList<>();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        recordsList = postService.getByUserID(user.getId());
        String json = new Gson().toJson(recordsList);
        return json;
    }

    @GetMapping(value = "/detay/{faultid}")
    public String detay(@PathVariable("faultid") Long faultid, HttpServletRequest request, HttpServletResponse response, Model model){
        FaultRecords faultRecord = postService.getByID(faultid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String strFaultRecord = gson.toJson(faultRecord);
        model.addAttribute("faultRecord", strFaultRecord);
        return "post/detay";
    }

    @PostMapping(value = "/update")
    public @ResponseBody String update(@RequestParam String strFaultRecord){

        FaultRecords faultRecord = postService.update(strFaultRecord);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", faultRecord);
        String json = gson.toJson(map);
        return json;
    }
    @GetMapping(value="/getAll")
    public @ResponseBody String getAllRecords(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        if(user.getRole()== UserRole.ADMIN)
        {
            List<FaultRecords> faultRecords=postService.getAll();
            map.put("success", true);
            map.put("data", faultRecords);
        }
        else
        {
            map.put("success",false);
        }
        String json = gson.toJson(map);
        return json;
    }

    @PostMapping(value = "/delete/{faultid}")
    public @ResponseBody String delete(@PathVariable("faultid") Long faultid){
        FaultRecords faultRecord = postService.getByID(faultid);
        Map<String, Object> map = new HashMap<>();

        boolean success = postService.delete(faultRecord);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        map.put("success", success);

        return gson.toJson(map);
    }

}
