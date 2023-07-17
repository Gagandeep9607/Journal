package com.gagan.journal.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
    
@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="First Name is required!")
    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
    private String firstName;
    
    @NotEmpty(message="Last Name is required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lastName;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
//    @NotEmpty(message="Occupation field should not be empty!")
//    @Size(min=3, max=30, message="Occupation must be between 3 and 30 characters")
//    private String profession;
//    
//    @NotEmpty(message="Hobbies are required!")
//    @Size(min=3, max=30, message="Hobbies must be between 3 and 30 characters")
//    private String hobby;
//    
//    @NotEmpty(message="Color is required!")
//    @Size(min=3, max=30, message="Color must be between 3 and 30 characters")
//    private String color;
//    
//    @NotEmpty(message="Name of the Place is required!")
//    @Size(min=3, max=30, message="Name of the Place must be between 3 and 30 characters")
//    private String place;
//    
//    @NotEmpty(message="Animal name is required!")
//    @Size(min=3, max=30, message="Animal Name must be between 3 and 30 characters")
//    private String pet;
//    
//    @NotEmpty(message="This is feild should not be left empty !")
//    @Size(min=1, max=1000, message="Could be 1000 characters")
//    private String about;
//    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Information> information;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Profile> profile;

    public User() {}

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
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getProfession() {
//		return profession;
//	}
//
//	public void setProfession(String profession) {
//		this.profession = profession;
//	}
//
//	public String getHobby() {
//		return hobby;
//	}
//
//	public void setHobby(String hobby) {
//		this.hobby = hobby;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public String getPlace() {
//		return place;
//	}
//
//	public void setPlace(String place) {
//		this.place = place;
//	}
//
//	public String getPet() {
//		return pet;
//	}
//
//	public void setPet(String pet) {
//		this.pet = pet;
//	}
//
//	public String getAbout() {
//		return about;
//	}
//
//	public void setAbout(String about) {
//		this.about = about;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public List<Profile> getProfile() {
		return profile;
	}

	public void setProfile(List<Profile> profiles) {
		this.profile = profiles;
	}

	public List<Information> getInformation() {
		return information;
	}

	public void setInformation(List<Information> information) {
		this.information = information;
	}

}
    
