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

import com.groupe1.sujet1.model.User;
import com.groupe1.sujet1.service.UserService;



@Controller
public class SubjectController {

   @Autowired
   private UserService userService;

   @GetMapping("/subjects")
   public String userForm(Locale locale, Model model) {

      model.addAttribute("user", new User());
      model.addAttribute("users", userService.list());

      return "userForm";
   }

   @PostMapping("/saveSubject")
   public String saveUser(@ModelAttribute("user") @Valid User user,
         BindingResult result, Model model) {

      if (result.hasErrors()) {
        
         model.addAttribute("users", userService.list());
         return "userForm";
      }

      userService.save(user);

      return "redirect:/";
   }
}