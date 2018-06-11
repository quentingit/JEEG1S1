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
   public void saveOrUpdate(User user) {
      sessionFactory.getCurrentSession().saveOrUpdate(user);
   }
   
  
   
   public void deleteStudent(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }
   
   
   public void updateStudent(User user) {
	      sessionFactory.getCurrentSession().update(user);
   }
   
   @Override
   public List<User> listByName(Object name) {
      @SuppressWarnings("unchecked")
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where name=:name");
	query.setParameter("name", name);
      return query.getResultList();
      //where name=:name
   }
   
   
   @Override
   public List<User> list() {
      @SuppressWarnings("unchecked")
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}