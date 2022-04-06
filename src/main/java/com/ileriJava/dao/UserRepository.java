package com.ileriJava.dao;

import com.ileriJava.model.User;

import java.util.List;

public interface UserRepository{

    public List< User > getUser();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);

    public User getByNameAndPassword(String kullaniciAdi, String sifre);
}
