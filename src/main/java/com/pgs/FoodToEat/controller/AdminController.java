package com.pgs.FoodToEat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pgs.FoodToEat.model.Admin;
import com.pgs.FoodToEat.model.Customers;
import com.pgs.FoodToEat.model.Login;
import com.pgs.FoodToEat.model.Vendors;
import com.pgs.FoodToEat.service.AdminServiceImpl;
import com.pgs.FoodToEat.service.CustomerService;
import com.pgs.FoodToEat.service.CustomerServiceImpl;
import com.pgs.FoodToEat.service.VendorServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@Autowired
	CustomerServiceImpl customerService ;
	
	@Autowired
	VendorServiceImpl vendorService ;
	
	@Autowired
	AdminServiceImpl adminService ;
	
	
	
	@GetMapping("/login")
	public String getloginpage() {
		return "login" ;
	}
	
	

	  @GetMapping("/login/adminlogin")
	  public String getadminlogin(Model m) {
		  m.addAttribute("adminobject", new Login());
		
		return "adminlogin" ;
	 }
	
	 @PostMapping("/login/adminlogin")
	 public String login(@ModelAttribute("adminobject") Login login ) {
	  String mail = login.getEmail() ;
	  String pass = login.getPassword();
	  Admin admin = adminService.signIn(mail, pass);
	  if(admin == null) {
	   
	   return "404";
	  }
	  return "adminHome";
	  
	 }
	
	
	
	

	@GetMapping("/admin/customers")
	public String getCustomers(Model model) {
		model.addAttribute("customers" ,customerService.getAllCustomers());
		return "customers" ;
	}
	
	@GetMapping("/admin/customers/add")
	public String getCustomersAdd(Model model) {
		model.addAttribute("customer" ,new Customers());
		return "customersAdd" ;
	}
	@PostMapping("/admin/customers/add")
	public String postCustomersAdd(@ModelAttribute("customer")Customers cust ) {
		customerService.addCustomer(cust);
		return "redirect:/admin/customers" ;
	}
	
	@GetMapping("/admin/customers/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.removeCustomerById(id);
		return "redirect:/admin/customers";
	}
	
	@GetMapping("/admin/customers/update/{id}")
	public String updateCustomer(@PathVariable Long id , Model model) {
		Optional<Customers> cust = customerService.getCustomerById(id);
		if(cust.isPresent()) {
			model.addAttribute("customer" ,cust.get());
			return  "customersAdd";
		}
		else {
			return "404" ;
		}
	}
	
	
	//vendor functions 
	
	@GetMapping("/admin/vendors")
	public String getVendors(Model model) {
		model.addAttribute("vendors" ,vendorService.getAllVendors());
		return "vendors" ;
	}
	
	@GetMapping("/admin/vendors/add")
	public String getVendorsAdd(Model model) {
		model.addAttribute("vendor" ,new Vendors());
		return "vendorsAdd" ;
	}
	@PostMapping("/admin/vendors/add")
	public String postVendorsAdd(@ModelAttribute("vendor")Vendors vend ) {
		vendorService.addVendor(vend);
		return "redirect:/admin/vendors" ;
	}
	@GetMapping("/admin/vendors/delete/{id}")
	public String deleteVendor(@PathVariable Long id) {
		vendorService.removeVendorById(id);
		return "redirect:/admin/vendors";
	}
	
	@GetMapping("/admin/vendors/update/{id}")
	public String updateVendor(@PathVariable Long id , Model model) {
		Optional<Vendors> vend = vendorService.getVendorById(id);
		if(vend.isPresent()) {
			model.addAttribute("vendor" ,vend.get());
			return  "vendorsAdd";
		}
		else {
			return "404" ;
		}
	}
	

}
