package com.groupe1.sujet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupe1.sujet1.dao.SubjectDao;
import com.groupe1.sujet1.model.Subject;

@Service
public class SubjectServiceImp implements SubjectService {

   @Autowired
   private SubjectDao subjectDao;

   @Transactional
   public void save(Subject subject) {
      subjectDao.save(subject);
   }

   @Transactional(readOnly = true)
   public List<Subject> list() {
      return subjectDao.list();
   }

}