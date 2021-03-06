package com.groupe1.sujet1.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupe1.sujet1.model.Subject;
import com.groupe1.sujet1.model.User;
import com.groupe1.sujet1.service.SubjectService;



@Controller
public class SubjectController {

   @Autowired
   private SubjectService subjectService;

   @GetMapping("/subjects")
   public String userForm(Locale locale, Model model) {

      model.addAttribute("subject", new Subject());
      model.addAttribute("subjects", subjectService.list());

      return "subjectForm";
   }

   @PostMapping("/saveSubject")
   public String saveUser(@ModelAttribute("subject") @Valid Subject subject,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
        
         model.addAttribute("subjects", subjectService.list());
         return "subjectForm";
      }

      subjectService.save(subject);

      return "redirect:/subjects";
   }
   
   
   
   
   
   //Update User 
   @PostMapping("/updatesubject")
   public String updateStudent(@ModelAttribute("subject") @Valid Subject subject,
	         BindingResult result, Model model)  {
	  
	      //update subject
	      subjectService.updateSubject(subject);
	      //redirect users page to see change
	      return "redirect:/subjects";      	
   }
   
   
   
   
   //Delete User
   @PostMapping("/deletesubject")
   public String deleteStudent(@ModelAttribute("subject") @Valid Subject subject,
	         BindingResult result, Model model)  {
	  
	      //delete user object with relation mark
	       subjectService.deleteSubject(subject);
	      //redirect users page to see change
	      return "redirect:/subjects";      	
   }
   
   
   
   
}