package com.groupe1.sujet1.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupe1.sujet1.model.Mark;


@Repository
public class MarkDaoImp implements MarkDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(Mark mark) {
      sessionFactory.getCurrentSession().save(mark);
   }

   @Override
   public List<Mark> list() {
      @SuppressWarnings("unchecked")
      TypedQuery<Mark> query = sessionFactory.getCurrentSession().createQuery("from Mark");
      return query.getResultList();
   }

}