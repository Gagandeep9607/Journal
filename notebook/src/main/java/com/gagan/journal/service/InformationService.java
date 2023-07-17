package com.gagan.journal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gagan.journal.models.Information;
import com.gagan.journal.repository.InformationRepo;

@Service
public class InformationService {

	 private final InformationRepo inforepo;
	 
	 public InformationService(InformationRepo inforepo)
	 {
	     this.inforepo = inforepo;
	 }
	
	 public List<Information> allInformations() 
	 {
	     return inforepo.findAll();
	 }
	
	 public Information createInformation(Information information) {
	     return inforepo.save(information);
	 }
	
	 public Information findInformation(Long id) 
	 {
	     Optional<Information> opt = inforepo.findById(id);
	     if(opt.isPresent()) {
	         return opt.get();
	     } else {
	         return null;
	     }
	 }
	 
	 public Information updateInformation(Information information)
	 {
	     return inforepo.save(information);
	 }	 
}
