package com.pgs.FoodToEat.service;

import java.util.List;
import java.util.Optional;

import com.pgs.FoodToEat.model.Admin;
import com.pgs.FoodToEat.model.FoodItems;
import com.pgs.FoodToEat.model.Vendors;
import com.pgs.FoodToEat.repo.FoodRepository;
import com.pgs.FoodToEat.repo.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{

	@Autowired
	VendorRepository vendorRepository ;
	
	
	private Long vendorid ;
	
	public Long getVendorid() {
		return this.vendorid;
	}

	public void addVendor(Vendors vendor) {
		  vendorRepository.save(vendor) ;
	}
	
	public List<Vendors> getAllVendors(){
		return (List<Vendors>)vendorRepository.findAll();
	}
	public void removeVendorById(Long id) {
		vendorRepository.deleteById(id);
	}
	public Optional<Vendors> getVendorById(Long id){
		return vendorRepository.findById(id);
	}

	public Vendors signIn(String mail, String pass) {
		Vendors vendor = vendorRepository.signIn(mail, pass);
		if(vendor !=null) {
			
			this.vendorid = vendor.getId();
			
		}
		
		return vendor ;
		
	}
	
	@Autowired
	FoodRepository foodRepository ;
	
	public List<FoodItems> getFoodsById(Long id){
		return foodRepository.findFoodsById(id) ;
		
		
	}
}
