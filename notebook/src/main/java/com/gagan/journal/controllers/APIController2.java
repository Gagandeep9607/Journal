package com.gagan.journal.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gagan.journal.models.Information;
import com.gagan.journal.models.User;
import com.gagan.journal.service.InformationService;

@RestController
public class APIController2 {

	private final InformationService informationService;
	public APIController2(InformationService informationService) 
	{
		this.informationService = informationService;
	}
 
	@RequestMapping("/api/informations")
	public List<Information> index()
	{
		return informationService.allInformations();
	}

	@RequestMapping(value="/api/informations", method=RequestMethod.POST)
	public Information create(
				 @RequestParam(value="id") Long id,		
				 @RequestParam(value="profession")String profession,
				 @RequestParam(value="hobby")String hobby,
				 @RequestParam(value="color")String color,
				 @RequestParam(value="place")String place,
				 @RequestParam(value="pet")String pet,
				 @RequestParam(value="about")String about,
				 @RequestParam(value="user") User user)
	{
		Information information = new Information(profession, hobby, color, place, pet, about);
		     		  
		return  informationService.createInformation(information);
	}
		
	@RequestMapping("/api/informations/{id}")
	public Information show(@PathVariable("id") Long id) 
	{
		Information information = informationService.findInformation(id);
		return information;
	}
		 
	@RequestMapping(value="/api/informations/{id}", method=RequestMethod.PUT)
	public Information update(
			 @RequestParam(value="id") Long id,		
			 @RequestParam(value="profession")String profession,
			 @RequestParam(value="hobby")String hobby,
			 @RequestParam(value="color")String color,
			 @RequestParam(value="place")String place,
			 @RequestParam(value="pet")String pet,
			 @RequestParam(value="about")String about,
			 @RequestParam(value="user") User user)
	{		  
		Information information = new Information(profession, hobby, color, place, pet, about);

		information.setId(id);
			  
		information = informationService.updateInformation(information);
		return information;
	}
		  
//	@RequestMapping(value="/api/informations/{id}", method=RequestMethod.DELETE)
//	public void destroy(@PathVariable("id") Long id) 
//	{
//		informationService.deleteInformation(id);
//	}
}
