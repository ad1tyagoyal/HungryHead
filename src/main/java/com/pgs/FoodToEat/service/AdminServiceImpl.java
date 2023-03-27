package com.pgs.FoodToEat.service;

import java.util.Optional;

import com.pgs.FoodToEat.model.Admin;
import com.pgs.FoodToEat.repo.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {

	@Autowired
	AdminRepository adminRepository ;
	
	
	private Long admin_id ;
	
	public Admin signIn(String mail , String password) {
		
	
	
	Admin admin = adminRepository.signIn(mail, password);
	if(admin !=null) {
		
		this.admin_id = admin.getId();
		
	}
	
	return admin ;
      }
	
	
	
	
	
	
}
