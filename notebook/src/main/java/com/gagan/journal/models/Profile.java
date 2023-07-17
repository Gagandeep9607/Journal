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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="profiles")
public class Profile {

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
	    
		private Profile() {}
//-----------------------------------------
		@NotNull(message="Name !")
	    @Size(min = 1, max=25)
	    private String name;
		
		@NotNull(message="Nickname")
		 @Size(min = 2, max=500)
		 private String nickname;
		
		@NotNull(message="contact")
	    @Size(min = 3, max=25)
	    private String contact;
		
		 @NotNull(message="Address")
		 @Size(min = 2, max=500)
		 private String address;
		 
		 @NotNull(message="relation")
		 @Size(min = 2, max=500)
		 private String relation;
		 
//-------------------------------------------
		 
		 public Profile(String name,String nickname,String contact, String address, String relation)
		 {
			 	this.name = name;
				this.nickname = nickname;
				this.contact = contact;
				this.address = address;
				this.relation = relation;
		 }
		 
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRelation() {
			return relation;
		}

		public void setRelation(String relation) {
			this.relation = relation;
		}
		
}
