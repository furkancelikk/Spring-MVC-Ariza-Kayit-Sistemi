package com.ileriJava.controller;

import com.google.gson.Gson;
import com.ileriJava.model.Personel;
import com.ileriJava.service.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author furkancelik
 **/
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/personel/*")
public class PersonelController {

    private final PersonelService personelService;

    @PostMapping(value = "/create")
    public @ResponseBody String create(@RequestParam String kullaniciAdi, @RequestParam String name,
                                       @RequestParam String surname, @RequestParam String email,
                                       @RequestParam String password, @RequestParam String categories){

        String[] categoryIDs = categories.split(",");
        boolean success = personelService.create(kullaniciAdi, name, surname, email, password, categoryIDs);
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    @GetMapping(value = "/getAll")
    public @ResponseBody String getAll(){
        List<Personel> personelList = personelService.getAll();
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data", personelList);
        return gson.toJson(map);
    }
}
