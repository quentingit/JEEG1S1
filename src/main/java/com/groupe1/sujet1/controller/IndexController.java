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
public class IndexController {

   @GetMapping("/")
   public String userForm(Locale locale, Model model) {
      return "index";
   }
   
   
   
   
   @Autowired
   private UserService userService;
   
   
   


}

