package com.groupe1.sujet1.service;

import java.util.List;

import com.groupe1.sujet1.model.Subject;

public interface SubjectService {
   void save(Subject subject);

   List<Subject> list();
}