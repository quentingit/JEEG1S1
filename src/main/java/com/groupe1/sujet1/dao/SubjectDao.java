package com.groupe1.sujet1.dao;

import java.util.List;

import com.groupe1.sujet1.model.Subject;

public interface SubjectDao {
   void save(Subject subject);
   void updateSubject(Subject subject);
   void deleteSubject(Subject subject);
   List<Subject> list();

}