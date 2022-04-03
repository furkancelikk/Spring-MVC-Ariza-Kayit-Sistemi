package com.ileriJava.dao;

import com.ileriJava.model.UserAlpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository   extends JpaRepository<UserAlpi, Integer>{




}
