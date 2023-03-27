package com.pgs.FoodToEat.service;

import java.util.List;
import java.util.Optional;

import com.pgs.FoodToEat.model.Customers;
import com.pgs.FoodToEat.model.Vendors;
import com.pgs.FoodToEat.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService{

  
	@Autowired
	CustomerRepository customerRepository ;
	
	private Long cust_id ;
	
	public void addCustomer(Customers customer) {
		  customerRepository.save(customer) ;
	}
	
	public List<Customers> getAllCustomers(){
		return (List<Customers>)customerRepository.findAll();
	}
	public void removeCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
	public Optional<Customers> getCustomerById(Long id){
		return customerRepository.findById(id);
	}
	
	public Customers signIn(String mail, String pass) {
		Customers cust = customerRepository.signIn(mail, pass);
		if(cust !=null) {
			
			this.cust_id = cust.getId();
			
		}
		
		return cust ;
		
	}
}
