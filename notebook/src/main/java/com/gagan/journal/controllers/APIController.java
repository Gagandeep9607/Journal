package com.gagan.journal.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gagan.journal.models.Profile;
import com.gagan.journal.models.User;
import com.gagan.journal.service.ProfileService;

@RestController
public class APIController {
	
	private final ProfileService insService;
	public APIController(ProfileService insService) 
	{
		this.insService = insService;
	}
 
	@RequestMapping("/api/profiles")
	public List<Profile> index()
	{
		return insService.allProfiles();
	}

	@RequestMapping(value="/api/profiles", method=RequestMethod.POST)
	public Profile create(
				 @RequestParam(value="id") Long id,		
				 @RequestParam(value="name")String name,
				 @RequestParam(value="nickname")String nickname,
				 @RequestParam(value="contact")String contact,
				 @RequestParam(value="address")String address,
				 @RequestParam(value="relation")String relation,
				 @RequestParam(value="user") User user)
	{
		Profile profile = new Profile(name, nickname, contact, address, relation);
		     		  
		return  insService.createProfile(profile);
	}
		
	@RequestMapping("/api/profiles/{id}")
	public Profile show(@PathVariable("id") Long id) 
	{
		Profile profile = insService.findProfile(id);
		return profile;
	}
		 
	@RequestMapping(value="/api/profiles/{id}", method=RequestMethod.PUT)
	public Profile update(
				@PathVariable("id") Long id, 
		  		@RequestParam(value="name") String name, 
		  		@RequestParam(value="nickname") String nickname, 
		  		@RequestParam(value="contact") String contact,
		  		@RequestParam(value="address") String address,
				@RequestParam(value="relation") String relation,
		  		@RequestParam(value="user") User user) 
	{		  
		Profile profile = new Profile(name, nickname, contact, address, relation);

		profile.setId(id);
			  
		profile = insService.updateProfile(profile);
		return profile;
	}
		  
	@RequestMapping(value="/api/profiles/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) 
	{
		insService.deleteProfile(id);
	}

}
