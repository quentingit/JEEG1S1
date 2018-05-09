package com.groupe1.sujet1.dao;

import java.util.List;

import com.groupe1.sujet1.model.User;

public interface UserDao {
   void save(User user);
   List<User> list();
}