package com.groupe1.sujet1.dao;

import java.util.List;

import com.groupe1.sujet1.model.User;

public interface UserDao {
   void save(User user);
   void update(User user);
   List<User> list();
   
   void saveOrUpdate(User user);
   
   
	
}