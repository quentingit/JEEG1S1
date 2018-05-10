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
	   

   @GetMapping("/mark")
   public String userForm(Locale locale, Model model) {

	  //for marks
      model.addAttribute("mark", new Mark());
      model.addAttribute("marks", markService.list());
      
      //for users
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

      markService.save(mark);

      return "redirect:/mark";
   }


}