package com.ileriJava.service;

import com.ileriJava.dao.MainDAO;
import com.ileriJava.dao.UserRepository;
import com.ileriJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private MainDAO mainDAO;

    public Boolean isExist(String email, String password) {
        if (email.indexOf("furkan") > -1)
            return true;
        return false;
    }

    @Transactional(readOnly = false)
    public void addUser(User user) {
         mainDAO.saveObject(user);
//       return new User();
    }
}
