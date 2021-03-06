package com.groupe1.sujet1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "SUBJECT_TBL")
public class Subject {

   @Id
   @GeneratedValue
   @Column(name = "id_subject")
   private Long id;

   @Column(name = "NAME")
   @Size(max = 20, min = 3, message = "{subject.name.invalid}")
   private String name;

   
   
   public Subject() {}
  
   
   public Subject(String name) {
	   this.name=name; 
   }
  
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


}


