package com.pgs.FoodToEat.model;

public class Login {
	 public Login(String email, String password) {
		super();
		Email = email;
		Password = password;
	}


	private String Email;
	 private String Password;
	 
	 
	 public Login() {
	  super();
	  // TODO Auto-generated constructor stub
	 }


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
	 
	
	 
	}
