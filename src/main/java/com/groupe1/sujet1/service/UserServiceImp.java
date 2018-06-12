package com.groupe1.sujet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupe1.sujet1.dao.UserDao;
import com.groupe1.sujet1.model.User;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   public void save(User user) {
      userDao.save(user);
   }
   
   @Transactional
   public void saveOrUpdate(User user) {
      userDao.saveOrUpdate(user);
   }
   
   
   @Transactional
   public void deleteStudent(User user) {
      userDao.deleteStudent(user);
   }
   
   @Transactional
   public void updateStudent(User user) {
      userDao.updateStudent(user);
   }
   
   
   @Transactional(readOnly = true)
   public List<User> list() {
      return userDao.list();
   }
   
   @Transactional(readOnly = true)
   public List<User> listByName(Object name) {
      return userDao.listByName(name);
   }
   
   @Transactional(readOnly = true)
   public  User userById(Long id) {
      return userDao.userById(id);
   }

}