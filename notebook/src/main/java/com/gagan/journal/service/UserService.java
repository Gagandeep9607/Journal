package com.gagan.journal.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.gagan.journal.models.User;
import com.gagan.journal.repository.UserRepo;
import com.gagan.journal.validators.LoginUser;

    
@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    //create
    public User create(User newUser)
    {
    	return this.userRepo.save(newUser);
    }
 
    public List<User> getall()
    {
    	return (List<User>) this.userRepo.findAll();
    }
   
    public User getById(Long thisID)
    {
    	return this.userRepo.findById(thisID).orElse(null);
    }
    // register and login methods!
    public User register(User newUser, BindingResult result)
    {

    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    
        if(potentialUser.isPresent())
        
        {
        	result.rejectValue("email", "Matches", "Wrong Email!");
        }
    
        if(!newUser.getPassword().equals(newUser.getConfirm())) 
        {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    
        if(result.hasErrors()) 
        {
        	return null;
        }
        
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        return this.create(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result)
    {
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
     
    	if(!potentialUser.isPresent())
            
        {
        	result.rejectValue("email", "Matches", "Please Register!");
        	return null;
        }
    	User thisUser = potentialUser.get();
     
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), thisUser.getPassword())) 
    	{
    	    result.rejectValue("password", "Matches", "Invalid Credentials!");
    	}
     
        if(result.hasErrors())
        {
        	return null;
        }
    
        return thisUser;
        
    }
}
