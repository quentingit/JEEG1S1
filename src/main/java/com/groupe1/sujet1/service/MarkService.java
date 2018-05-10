package com.groupe1.sujet1.service;

import java.util.List;

import com.groupe1.sujet1.model.Mark;

public interface MarkService {
   void save(Mark mark);

   List<Mark> list();
}