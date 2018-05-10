package com.groupe1.sujet1.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupe1.sujet1.model.Subject;


@Repository
public class SubjectDaoImp implements SubjectDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(Subject subject) {
      sessionFactory.getCurrentSession().save(subject);
   }

   @Override
   public List<Subject> list() {
      @SuppressWarnings("unchecked")
      TypedQuery<Subject> query = sessionFactory.getCurrentSession().createQuery("from Subject");
      return query.getResultList();
   }

}