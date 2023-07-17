package com.gagan.journal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gagan.journal.models.Information;
import com.gagan.journal.models.Profile;
import com.gagan.journal.models.User;
import com.gagan.journal.service.InformationService;
import com.gagan.journal.service.ProfileService;
import com.gagan.journal.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService insService;
	
	@Autowired
	private InformationService informationService;
	
	@Autowired
	private UserService userService;
	
//------------------------------------------------------------------
	
	@GetMapping("/addinfo")
	public String allinformation(@ModelAttribute("information") Information information, 
			Model model,
			HttpSession session)
	{
		if(session.getAttribute("userId") == null)		 
		{
			 return "redirect:/";
		}
		User user = userService.getById((Long) session.getAttribute("userId"));
		List<Information> informations = informationService.allInformations();
		model.addAttribute("informations", informations);
		return "addinfo.jsp";
	}
	    
    @PostMapping("/addinfo")
    public String allinformations(@Valid @ModelAttribute("information") Information information,
    		BindingResult result,
    		Model model,
    		HttpSession session) 
    {
    	if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
        if (result.hasErrors()) 
        {
        	List<Information> informations = informationService.allInformations();
            model.addAttribute("informations", informations);
            return "addinfo.jsp";
        } else {
        	information.setUser(userService.getById((Long) session.getAttribute("userId")));
        	informationService.createInformation(information);
            return "redirect:/home";
        }
    }
	
//------------------------------------------------------------------
	@GetMapping("/addcontact")
	public String allprofile(@ModelAttribute("profile") Profile profile, 
			Model model,
			HttpSession session)
	{
		if(session.getAttribute("userId") == null)		 
		{
			 return "redirect:/";
		}
		User user = userService.getById((Long) session.getAttribute("userId"));
		List<Profile> profiles = insService.allProfiles();
		model.addAttribute("profiles", profiles);
		return "addcontact.jsp";
	}
	    
    @PostMapping("/addcontact")
    public String allprofiles(@Valid @ModelAttribute("profile") Profile profile,
    		BindingResult result,
    		Model model,
    		HttpSession session) 
    {
    	if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
        if (result.hasErrors()) 
        {
        	List<Profile> profiles = insService.allProfiles();
            model.addAttribute("profiles", profiles);
            return "addcontact.jsp";
        } else {
        	profile.setUser(userService.getById((Long) session.getAttribute("userId")));
            insService.createProfile(profile);
            return "redirect:/home";
        }
    }
	
//--------------------------------------------------
    
	 @RequestMapping(value="/{id}/editinfo")
	 public String editInformation(@PathVariable("id") Long id, Model model,HttpSession session) 
	 {
		 if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
		 Information information = informationService.findInformation(id);
		 model.addAttribute("information", information);
		 return "editinfo.jsp";
	 }
	    
	 @RequestMapping(value="/{id}/editinfo", method=RequestMethod.PUT)
	 public String updateInformation(@Valid @ModelAttribute("information") Information information,
			 BindingResult result,
			 @PathVariable("id") Long id,
			 Model model,
			 HttpSession session) 
	 {
		 if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
		 if (result.hasErrors()) 
		 {
			 model.addAttribute("information", information);
			 return "editinfo.jsp";
		 } 
		 information.setUser(userService.getById((Long) session.getAttribute("userId")));
		 informationService.updateInformation(information);
		 return "redirect:/home";
	 }
	
//--------------------------------------------

	@GetMapping("/{id}/contactdetail")
	public String showdetail(Model model,@PathVariable("id") Long id,HttpSession session)
	{
		if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
		
		Profile profile = insService.findProfile(id);
			
		model.addAttribute("profile", profile);
				
		return "contactdetail.jsp";
	}
	
//-------------------------------------------
	
	@GetMapping("/{id}/userdetails")
	public String showuserdetail(Model model,@PathVariable("id") Long id,HttpSession session)
	{
		if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }				
		Information information = informationService.findInformation(id);
				
		model.addAttribute("information", information);
				
		return "userdetails.jsp";
	}
	
//-------------------------------------------
	
	 @RequestMapping(value="/{id}/editcontact")
	 public String editContact(@PathVariable("id") Long id, Model model,HttpSession session) 
	 {
		 if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
		 Profile profile = insService.findProfile(id);
		 model.addAttribute("profile", profile);
		 return "editcontact.jsp";
	 }
	    
	 @RequestMapping(value="/{id}/editcontact", method=RequestMethod.PUT)
	 public String updateProfile(@Valid @ModelAttribute("profile") Profile profile,
			 BindingResult result,
			 @PathVariable("id") Long id,
			 Model model,
			 HttpSession session) 
	 {
		 if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
		 if (result.hasErrors()) 
		 {
			 model.addAttribute("profile", profile);
			 return "editcontact.jsp";
		 } 
		 profile.setUser(userService.getById((Long) session.getAttribute("userId")));
		 insService.updateProfile(profile);
		 return "redirect:/home";
	 }
	
//-------------------------------------------------------
	 
	@GetMapping("/{id}/deletecontact")
    public String destroy(@PathVariable("id") Long id,HttpSession session) 
	{
		if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
        insService.deleteProfile(id);
        return "redirect:/home";
    }
    
}
