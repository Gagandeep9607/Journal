package com.gagan.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gagan.journal.models.User;
import com.gagan.journal.service.InformationService;
import com.gagan.journal.service.ProfileService;
import com.gagan.journal.service.UserService;
import com.gagan.journal.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
	
	@Autowired
	private InformationService informationService;
	
	@Autowired
	private ProfileService insService;

	@GetMapping("/")
	public String index(Model model)
	{
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "login.jsp";
	}
 
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) 
	{
		User thisUser = this.userService.register(newUser, result);
		if(result.hasErrors()) 
		{
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("userId", thisUser.getId());
		return "redirect:/addinfo";
	}
 
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session) 
	{
		User thisUser = userService.login(newLogin, result);
	    if(result.hasErrors()) 
	    {
	         model.addAttribute("newUser", new User());
	         return "login.jsp";
	    }
	    session.setAttribute("userId", thisUser.getId());
	    return "redirect:/home";
	}
 
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		 session.invalidate();
		 return "redirect:/";
	}
 
	 @GetMapping("/home")
	 public String home(Model model, HttpSession session)
	 {
		 if(session.getAttribute("userId") == null)
		 {
			 return "redirect:/";
		 }
		 model.addAttribute("informations", informationService.allInformations());
		 model.addAttribute("profiles", insService.allProfiles());
		 model.addAttribute("user", userService.getById((Long) session.getAttribute("userId")));
		 return "dashboard.jsp";
	 }
}

