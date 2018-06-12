package com.groupe1.sujet1.dao;

import java.util.List;

import com.groupe1.sujet1.model.Mark;

public interface MarkDao {
   void save(Mark subject);
   void deleteMark(Mark mark);
   List<Mark> list();
}