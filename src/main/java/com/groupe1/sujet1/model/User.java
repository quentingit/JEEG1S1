package com.groupe1.sujet1.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;








@Entity
@Table(name = "USER_TBL")
public class User {

   @Id
   @GeneratedValue
   @Column(name = "id_user")
   private Long id;

   @Column(name = "NAME")
   @Size(max = 20, min = 3, message = "{user.name.invalid}")
   public String name;

   
   
   @Column(name = "EMAIL", unique = true)
   @Email(message = "{user.email.invalid}")
   private String email;

   
   @OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "note", joinColumns = 
	@JoinColumn(name = "id_user"), 
	inverseJoinColumns = @JoinColumn(name = "id_mark"))
	public List<Mark> studentNote;


   
   
   public User(){}
   
   public User(String name) {
	this.name= name;
   }

   public User(String name, String email) {
    this.name= name;
	this.email= email;
   }

	public User(long id, String name, String email) {
		this.id=id;
		this.name= name;
		this.email= email;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   
   
   
   public List<Mark> getStudentNote() {
		return studentNote;
	}

	public void setStudentNote(List<Mark> studentNote) {
		this.studentNote = studentNote;
	}

}


