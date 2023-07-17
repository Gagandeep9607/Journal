package com.gagan.journal.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="informations")
public class Information {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	 @PrePersist
		protected void onCreate()
		{
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate()
		{
			this.updatedAt = new Date();
		}
	    
		private Information() {}
		
//-----------------------------------
		
		@NotEmpty(message="Occupation field should not be empty!")
	    @Size(min=3, max=30, message="Occupation must be between 3 and 30 characters")
	    private String profession;
	    
	    @NotEmpty(message="Hobbies are required!")
	    @Size(min=3, max=30, message="Hobbies must be between 3 and 30 characters")
	    private String hobby;
	    
	    @NotEmpty(message="Color is required!")
	    @Size(min=3, max=30, message="Color must be between 3 and 30 characters")
	    private String color;
	    
	    @NotEmpty(message="Name of the Place is required!")
	    @Size(min=3, max=30, message="Name of the Place must be between 3 and 30 characters")
	    private String place;
	    
	    @NotEmpty(message="Animal name is required!")
	    @Size(min=3, max=30, message="Animal Name must be between 3 and 30 characters")
	    private String pet;
	    
	    @NotEmpty(message="This is feild should not be left empty !")
	    @Size(min=1, max=1000, message="Could be 1000 characters")
	    private String about;
	    
//-------------------------------------------------------------------
	    
		public Information(
				String profession, String hobby, String color, String place, String pet, String about) 
		{
			this.profession = profession;
			this.hobby = hobby;
			this.color = color;
			this.place = place;
			this.pet = pet;
			this.about = about;
		}

//-------------------------------------------------------------------
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getProfession() {
			return profession;
		}

		public void setProfession(String profession) {
			this.profession = profession;
		}

		public String getHobby() {
			return hobby;
		}

		public void setHobby(String hobby) {
			this.hobby = hobby;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getPlace() {
			return place;
		}

		public void setPlace(String place) {
			this.place = place;
		}

		public String getPet() {
			return pet;
		}

		public void setPet(String pet) {
			this.pet = pet;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}
	    	    
}
