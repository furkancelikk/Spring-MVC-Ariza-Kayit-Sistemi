package com.ileriJava.service;

import com.ileriJava.dao.MainDAO;
import com.ileriJava.dao.UserRepository;
import com.ileriJava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class UserService {

    private final MainDAO mainDAO;
    private final UserRepository userRepository;

    public UserService(MainDAO mainDAO, UserRepository userRepository) {
        this.mainDAO = mainDAO;
        this.userRepository = userRepository;
    }

    public Boolean isExist(String email, String password) {
        if (email.indexOf("furkan") > -1)
            return true;
        return false;
    }

    @Transactional(readOnly = false)
    public void addUser(User user) {
         mainDAO.saveObject(user);
    }

    @Transactional(readOnly = false)
    public List<User> getAll() {
        return userRepository.getUser();
    }

    @Transactional(readOnly = false)
    public User getByKullaniciAdiAndSifre(String kullaniciAdi, String sifre) {
        return userRepository.getByNameAndPassword(kullaniciAdi, sifre);
//       return new User();
    }
}
