package com.ileriJava.dao;


import java.util.List;

public interface PostRepository {
    List findByUserID(Long userID);
}
