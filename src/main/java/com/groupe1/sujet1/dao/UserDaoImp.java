package com.groupe1.sujet1.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupe1.sujet1.model.User;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   
   
   @Override
   public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
   }
   
   
   @Override
   public void saveOrUpdate(User user) {
      sessionFactory.getCurrentSession().saveOrUpdate(user);
   }
   
   

   @Override
   public List<User> list() {
      @SuppressWarnings("unchecked")
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}