package com.groupe1.sujet1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupe1.sujet1.model.All;
import com.groupe1.sujet1.model.Mark;
import com.groupe1.sujet1.model.Subject;
import com.groupe1.sujet1.model.User;
import com.groupe1.sujet1.service.MarkService;
import com.groupe1.sujet1.service.SubjectService;
import com.groupe1.sujet1.service.UserService;


@Controller
public class MarkController {


		
	@Autowired
	private MarkService markService;

	@Autowired
	private UserService userService;
	 
	@Autowired
	private SubjectService subjectService;
	
	
	//AJOUTER UNE NOTE OU MODIFIER LA NOTE
	@PostMapping("/addmarkuser")
	   public String saveMarkUser(
			      Model model,
				 @ModelAttribute("all")All all, BindingResult resultall) {


			 
			 
		   //Select User Object
		   User student = new User();
		   student = userService.userById(all.getUser().id);
			
	   
		   System.out.println("ca vaut :" + all.getSubject().getId());
		   
		   Subject subject = new Subject();
		   subject = subjectService.subjectById(all.getSubject().getId());
		   
		   
		   
	       //Get Subject & Set Subject to Mark	
		   
		   Mark mark = new Mark(all.getMark().getMark());
		   mark.setNote_formation(subject);	      
		   
		   //Get list of User Mark & Add to the list of mark 
	  	   List<Mark> listMark = new ArrayList<Mark>();
	  	   listMark= student.getStudentNote();
	  	   listMark.add(mark);
	       student.setStudentNote(listMark);      
	      	              
	      //save mark and saveOrUpdate student    	         
	       markService.save(mark);
	       userService.saveOrUpdate(student);
	        
	       return "redirect:/mark";
	   }	
	
	   

   @GetMapping("/mark")
   public String userForm(Locale locale, Model model) {


      //for list users
      model.addAttribute("user", new User());
      model.addAttribute("users", userService.list());
          
      //for list subjects
      model.addAttribute("subject", new Subject());
      model.addAttribute("subjects", subjectService.list());
      
      
      //for list subjects
      model.addAttribute("mark", new Subject());
      model.addAttribute("marks", markService.list());
        
      //for all attribute (multi model)
      All all = new All();
      model.addAttribute("all", all);
      
      return "markForm";
   }
   
   
   
   //Delete User
   @PostMapping("/deletemark")
   public String deleteMark(@ModelAttribute("mark") @Valid Mark mark,
	         BindingResult result, Model model)  {
	  
	      //delete user object with relation mark
	       markService.deleteMark(mark);
	      //redirect users page to see change
	      return "redirect:/mark";      	
   }
   


   

}