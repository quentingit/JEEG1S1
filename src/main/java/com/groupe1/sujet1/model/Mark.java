package com.groupe1.sujet1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;



	@Entity
	@Table(name = "MARK_TBL")
	public class Mark {

   @Id
   @GeneratedValue
   @Column(name = "UID")
   private Long id;

   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "USR_ID", nullable = false)
   private User user;
   
   
   @Column(name = "MARK")
   @Size(max = 2, min = 1, message = "{mark.mark.invalid}")
   private String mark;

    
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getMark() {
      return mark;
   }

   public void setMark(String mark) {
      this.mark = mark;
   }
   
   
	public void setUser(User user) {
		this.user = user;
		
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return this.user;
	}
	

}

