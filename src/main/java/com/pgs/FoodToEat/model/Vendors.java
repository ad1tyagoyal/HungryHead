package com.pgs.FoodToEat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"Phone", "Email","Password"})
	})
public class Vendors implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Id")
	private Long Id;
    @Column(name ="Name")
	private String Name;
    @Column(name ="Phone")
	private String Phone;
    @Column(name ="Email")
	private String Email;
   
    @Column(name ="Password")
	private String Password;
	
	
	public Vendors(Long id, String name, String phone, String email, String password) {
		super();
		this.Id = id;
		this.Name = name;
		this.Phone = phone;
		this.Email = email;
		this.Password = password;
	}

	public Vendors() {}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	
	
}
