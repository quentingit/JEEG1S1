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


import com.groupe1.sujet1.model.Mark;
import com.groupe1.sujet1.model.Subject;
import com.groupe1.sujet1.model.User;
import com.groupe1.sujet1.service.MarkService;
import com.groupe1.sujet1.service.UserService;


@Controller
public class MarkController {


		
	
	
	
	@Autowired
	private MarkService markService;

	@Autowired
	private UserService userService;
	   
	
	@GetMapping("/testmark")
	   public String saveUser1(@ModelAttribute("mark") @Valid Mark mark,
	         BindingResult result, Model model) {

	      if (result.hasErrors()) {
	        
	         model.addAttribute("marks", markService.list());
	         return "markForm";
	      }
	      
	      Random rand = new Random();

	      int  n = rand.nextInt(50) + 1;
	      
	      
	      //RECUPER UN ETUDIANT EN OBJET
	      
	      //ENSUITE LUI AJOUTER UN UNE NOUVELLE NOTE
	      
	      
	      //FAIRE UN SAVE OR UPDATE POUR REPLACER LES DONNEES DE CET OBJET
	      
	      
	      
	      //User student = new User("Cilia","test@gmail.com"+n);
	      User student = new User(13,"Cilia","test@gmail.com7");
	      
	      
		   Subject subject = new Subject("java");
		   Mark mark1 = new Mark("18");
		   mark1.setNote_formation(subject);
	      
	  	   List<Mark> listMark = new ArrayList<Mark>();
	  	   listMark.add(mark1);
	  	   
	  	   
	       student.setStudentNote(listMark);
	      
	     
	        markService.save(mark1);
	        userService.saveOrUpdate(student);

	      return "redirect:/mark";
	   }
	
	
	   

   @GetMapping("/mark")
   public String userForm(Locale locale, Model model) {

	  //for marks
      model.addAttribute("mark", new Mark());
      model.addAttribute("marks", markService.list());
      
      //for user
      model.addAttribute("user", new User());
      model.addAttribute("users", userService.list());
      
      
    
      return "markForm";
   }
   
   
   @PostMapping("/saveMark")
   public String saveUser(@ModelAttribute("mark") @Valid Mark mark,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
        
         model.addAttribute("marks", markService.list());
         return "markForm";
      }
   
      
      //markService.save(mark);

      return "redirect:/mark";
   }


}