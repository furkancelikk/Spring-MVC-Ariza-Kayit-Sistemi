package com.ileriJava.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public Boolean isExist(String email, String password) {
        if (email.indexOf("furkan") > -1)
            return true;
        return false;
    }
}
