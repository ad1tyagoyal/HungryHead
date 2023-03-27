package com.pgs.FoodToEat.controller;

import java.util.Optional;

import com.pgs.FoodToEat.model.Admin;
import com.pgs.FoodToEat.model.FoodItems;
import com.pgs.FoodToEat.model.Login;
import com.pgs.FoodToEat.model.Vendors;
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
public class VendorController {
	
	@Autowired
	FoodServiceImpl foodService;
	
	@Autowired
	VendorServiceImpl vendorService;


	
	
	 @GetMapping("/login/vendorlogin")
	  public String getvendorlogin(Model m) {
		  m.addAttribute("vendorobject", new Login());
		
		return "vendorlogin" ;
	 }
	
	 @PostMapping("/login/vendorlogin")
	 public String postVendorlogin(@ModelAttribute("vendorobject") Login login , Model m ) {
	  String mail = login.getEmail() ;
	  String pass = login.getPassword();
	  Vendors vendor = vendorService.signIn(mail, pass);
	  if(vendor == null) { 
	   return "404";
	  }
	  
	  else {
		  
	  m.addAttribute("VendorId" ,vendor.getId());
	  m.addAttribute("VendorName" , vendor.getName());
	  return "vendorHome";}
	  
	 }
	
		
		
		@GetMapping("/login/vendorlogin/fooditems/{id}")
		public String getFoodItems(@PathVariable Long id, Model model) {
			model.addAttribute("fooditems" ,vendorService.getFoodsById(id));
			model.addAttribute("vid", id);
			return "fooditems" ;
		}
	 
	    @GetMapping("/login/vendorlogin/fooditems/{id}/add")
		public String getFoodItemsAdd(@PathVariable Long id,Model model) {
			model.addAttribute("fooditem" ,new FoodItems());
			model.addAttribute("vid", id);
			return "FooditemsAdd" ;
		}

	
	    @PostMapping("/login/vendorlogin/fooditems/{id}/add")
		public String postFoodItemsAdd(@ModelAttribute("fooditem")FoodItems food ,@PathVariable Long id ) {
	    	foodService.addfood(food);
	    	return "redirect:/login/vendorlogin/fooditems/"+id;
		
			 }
	    
	    @GetMapping("/login/vendorlogin/fooditems/{id}/delete/{fid}")
		public String deleteFoodItem(@PathVariable Long id , @PathVariable Long fid) {
			foodService.removeFoodById(fid);
			return "redirect:/login/vendorlogin/fooditems/"+id;
		}
	
	    @GetMapping("/login/vendorlogin/fooditems/{id}/update/{fid}")
		public String updateVendor(@PathVariable Long id , Model model ,@PathVariable Long fid) {
			Optional<FoodItems> food = foodService.getFoodItemById(fid);
			if(food.isPresent()) {
				model.addAttribute("fooditem",food.get());
				model.addAttribute("vid", id);
				return  "FooditemsAdd";
			}
			else {
				return "404" ;
			}
		}
	
	
	
	
}
