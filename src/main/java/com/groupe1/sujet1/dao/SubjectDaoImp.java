package com.groupe1.sujet1.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.groupe1.sujet1.model.Subject;
import com.groupe1.sujet1.model.User;


@Repository
public class SubjectDaoImp implements SubjectDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void save(Subject subject) {
      sessionFactory.getCurrentSession().save(subject);
   }

   @Override
   public void updateSubject(Subject subject) {
      sessionFactory.getCurrentSession().update(subject);
   }
   
   
   @Override
   public void deleteSubject(Subject subject) {
      sessionFactory.getCurrentSession().delete(subject);
   }
   
   @Override
   public Subject subjectById(long id) {
     //create user and add id
      Subject subject = new Subject();
      subject.setId(id);
      
      //get user object by id
      subject= sessionFactory.getCurrentSession().get(Subject.class, id);
      
      return subject;
   }
   
   
   @Override
   public List<Subject> list() {
      @SuppressWarnings("unchecked")
      TypedQuery<Subject> query = sessionFactory.getCurrentSession().createQuery("from Subject");
      return query.getResultList();
   }

}