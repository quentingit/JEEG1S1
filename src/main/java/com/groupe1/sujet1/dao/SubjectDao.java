package com.groupe1.sujet1.dao;

import java.util.List;

import com.groupe1.sujet1.model.Subject;

public interface SubjectDao {
   void save(Subject subject);
   void updateSubject(Subject subject);
   void deleteSubject(Subject subject);
   Subject subjectById(long id);
   List<Subject> list();


}