package com.ileriJava.service;

import com.ileriJava.dao.MainDAO;
import com.ileriJava.enums.UserRole;
import com.ileriJava.model.Category;
import com.ileriJava.model.Personel;
import com.ileriJava.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author furkancelik
 **/
@RequiredArgsConstructor
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
public class PersonelService {

    private final MainDAO mainDAO;

    @Transactional
    public boolean create(String kullaniciAdi, String name, String surname, String email, String password, String[] categoryIDs) {

        Personel personel = new Personel();
        User user = new User();

        user.setAd(name);
        user.setSoyad(surname);
        user.setRole(UserRole.PERSONNEL);
        user.setSifre(password);
        user.setKullaniciAdi(kullaniciAdi);
        user.setEmail(email);

        personel.setUser(user);

        List<Category> categoryList = new ArrayList<>();
        try {
            for (String strID: categoryIDs) {
                Category category = (Category) mainDAO.loadObject(Category.class, Long.parseLong(strID));
                categoryList.add(category);
            }
            personel.setCategories(categoryList);
            mainDAO.saveObject(personel);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
