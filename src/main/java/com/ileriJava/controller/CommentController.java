package com.ileriJava.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ileriJava.model.Comments;
import com.ileriJava.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author furkancelik
 **/

@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping(value = "/save")
    public @ResponseBody String saveComment(@RequestParam String commentContext, @RequestParam Long faultRecordID, HttpServletRequest request, HttpServletResponse response){
        Comments comment = commentService.save(commentContext, faultRecordID, request, response);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", comment);
        String json = gson.toJson(map);
        return json;
    }

    @GetMapping(value = "/getByPost")
    public @ResponseBody String getByPost(@RequestParam Long postID){
        List<Comments> commentList = commentService.getByPostID(postID);
        Gson gson = new Gson();

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", commentList);
        String json = gson.toJson(map);
        return json;
    }
}
