package com.ileriJava.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Boolean isExist(String username, String password) {
        if (username.equals("furkan"))
            return true;
        return false;
    }
}
