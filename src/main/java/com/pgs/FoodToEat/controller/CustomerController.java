package com.pgs.FoodToEat.controller;

import com.pgs.FoodToEat.model.Customers;
import com.pgs.FoodToEat.model.FoodItems;
import com.pgs.FoodToEat.model.Login;
import com.pgs.FoodToEat.model.Vendors;
import com.pgs.FoodToEat.service.CustomerServiceImpl;
import com.pgs.FoodToEat.service.FoodServiceImpl;
import com.pgs.FoodToEat.service.VendorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;
	@Autowired
	 FoodServiceImpl foodService;
	
	 @GetMapping("/login/customerlogin")
	  public String getcustomerlogin(Model m) {
		  m.addAttribute("customerobject", new Login());
		
		return "customerlogin" ;
	 }
	
	 @PostMapping("/login/customerlogin")
	 public String postcustomerlogin(@ModelAttribute("customerobject") Login login , Model m) {
	  String mail = login.getEmail() ;
	  String pass = login.getPassword();
	  Customers cust = customerService.signIn(mail, pass);
	  if(cust == null) {
	   
	   return "404";
	  }
	  m.addAttribute("custId" ,   cust.getId());
	  m.addAttribute("custName" , cust.getName());
	  return "customerHome";
	  
	 }
	 
	 
	 @GetMapping("/login/customerlogin/viewfood/{id}")
	 public String getViewFood(@PathVariable Long id, Model model) {
			model.addAttribute("fooditems" ,foodService.getAllFood());
		    model.addAttribute("custId", id);
			return "viewallfood" ;
		}
	 
//	 @GetMapping("/login/vendorlogin/fooditems/{cid}/add/{vid}/{fid}")
//		public String getFoodItemsAdd(@PathVariable Long cid,@PathVariable Long vid,@PathVariable Long fid,Model model) {
//			model.addAttribute("fooditem" ,new FoodItems());
//			model.addAttribute("vid", id);
//			return "FooditemsAdd" ;
//		}
//
//	
//	    @PostMapping("/login/vendorlogin/fooditems/{id}/add")
//		public String postFoodItemsAdd(@ModelAttribute("fooditem")FoodItems food ,@PathVariable Long id ) {
//	    	foodService.addfood(food);
//	    	return "redirect:/login/vendorlogin/fooditems/"+id;
//		
//			 }
//	 
	

}
