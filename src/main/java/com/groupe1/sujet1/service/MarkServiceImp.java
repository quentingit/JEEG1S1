package com.groupe1.sujet1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupe1.sujet1.dao.MarkDao;
import com.groupe1.sujet1.model.Mark;
import com.groupe1.sujet1.model.Subject;

@Service
public class MarkServiceImp implements MarkService {

   @Autowired
   private MarkDao markDao;

   @Transactional
   public void save(Mark mark) {
      markDao.save(mark);
   }

   @Transactional(readOnly = true)
   public List<Mark> list() {
      return markDao.list();
   }
   
   @Transactional
   public void deleteMark(Mark mark) {
      markDao.deleteMark(mark);
   }


}