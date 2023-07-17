package com.gagan.journal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gagan.journal.models.Profile;
import com.gagan.journal.repository.ProfileRepo;

@Service
public class ProfileService {

	 private final ProfileRepo repo;
	 
	 public ProfileService(ProfileRepo repo)
	 {
	     this.repo = repo;
	 }
	
	 public List<Profile> allProfiles() 
	 {
	     return repo.findAll();
	 }
	
	 public Profile createProfile(Profile profile) {
	     return repo.save(profile);
	 }
	
	 public Profile findProfile(Long id) 
	 {
	     Optional<Profile> opt = repo.findById(id);
	     if(opt.isPresent()) {
	         return opt.get();
	     } else {
	         return null;
	     }
	 }
	 
	 public Profile updateProfile(Profile profile)
	 {
	     return repo.save(profile);
	 }
	 
	 public void deleteProfile(Long id)
	 {
		 repo.deleteById(id);
	 }
}
