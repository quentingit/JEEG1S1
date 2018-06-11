package com.groupe1.sujet1.service;

import java.util.List;

import com.groupe1.sujet1.model.User;

public interface UserService {
   void save(User user);
   void saveOrUpdate(User student);
   void deleteStudent(User user);
   void updateStudent(User user);
   
   List<User> list();
   List<User> listByName(Object name);


}