package com.ileriJava.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ileriJava.model.Category;
import com.ileriJava.model.FaultRecords;
import com.ileriJava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/create")
    public @ResponseBody String create(@RequestParam String name, @RequestParam String description){
        Boolean success = categoryService.create(name, description);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();

        map.put("success", success);

        return gson.toJson(map);
    }

    @GetMapping(value = "/detay/{id}")
    private String getByID(@PathVariable("id") Long id, Model model){
        Category category = categoryService.getByID(id);
        model.addAttribute("category", category);
        return "category/detay";
    }
}
