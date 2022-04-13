package com.ileriJava.controller;

import com.google.gson.Gson;
import com.ileriJava.model.Category;
import com.ileriJava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author furkancelik
 **/

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/getAll")
    public @ResponseBody String getAll(){
        List<Category> categories = categoryService.getAll();
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();

        map.put("success", true);
        map.put("data", categories);

        return gson.toJson(map);
    }
}
