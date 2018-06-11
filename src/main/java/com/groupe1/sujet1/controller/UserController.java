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

import com.groupe1.sujet1.model.Mark;
import com.groupe1.sujet1.model.User;
import com.groupe1.sujet1.service.UserService;



@Controller
public class UserController {

   @Autowired
   private UserService userService;

   @GetMapping("/users")
   public String userForm(Locale locale, Model model) {

      model.addAttribute("user", new User());
      model.addAttribute("users", userService.list());
      
      return "userForm";
     
   }

   
   //Save Student
   @PostMapping("/saveUser")
   public String saveUser(@ModelAttribute("user") @Valid User user,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
         
         model.addAttribute("users", userService.list());
         return "userForm";
      }
      //save the user object 
      userService.save(user);
      //redirect users page to see change
      return "redirect:/users";
   }
   
   
   
   //Search Student
   @PostMapping("/searchStudent")
   public String searchStudent(@ModelAttribute("user") @Valid User user,
         BindingResult result, Model model) {
	   
	    model.addAttribute("user", new User());
	    //User.name as an argument to search people with the good name
	    model.addAttribute("users", userService.listByName(user.name));

	    return "/searchResult";
   }
   
   
   //Update User 
   @PostMapping("/updatestudent")
   public String updateStudent(@ModelAttribute("user") @Valid User user,
         BindingResult result, Model model) {
	  
	      //delete user object with relation mark
	      userService.updateStudent(user);
	      //redirect users page to see change
	      return "redirect:/users";      	
   }
   
   
   
   
   //Delete User
   @PostMapping("/deletestudent")
   public String deleteStudent(@ModelAttribute("user") @Valid User user,
         BindingResult result, Model model) {
	  
	      //delete user object with relation mark
	      userService.deleteStudent(user);
	      //redirect users page to see change
	      return "redirect:/users";      	
   }
   
   
}