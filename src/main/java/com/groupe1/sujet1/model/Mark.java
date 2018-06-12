package com.groupe1.sujet1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import javax.persistence.CascadeType;





	@Entity
	@Table(name = "MARK_TBL")
	public class Mark {

   @Id
   @GeneratedValue
   @Column(name = "id_mark")
   private Long id;

   
   //@ManyToOne(fetch = FetchType.LAZY)
   //@JoinColumn(name = "USR_ID", nullable = false)
   //private User user;
   
   
   
  
	 
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_formation")
	private Subject note_formation;
   
    
    
   
   @Column(name = "MARK")
   @Size(max = 2, min = 1, message = "{mark.mark.invalid}")
   private String mark;

   
   
   
   public Mark() {}
   
   
   public Mark(String mark) {
	   this.mark = mark;
   }
   
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
   
   
   public Subject getNote_formation() {
		return note_formation;
	}

	public void setNote_formation(Subject note_formation) {
		this.note_formation = note_formation;
	}



   
   


}

