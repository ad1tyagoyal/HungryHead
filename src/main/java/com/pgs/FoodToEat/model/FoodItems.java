package com.pgs.FoodToEat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
@Entity
@Table
public class FoodItems {
	
	public Long getfId() {
		return fId;
	}
	public void setfId(Long fId) {
		this.fId = fId;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public String getfDesc() {
		return fDesc;
	}
	public void setfDesc(String fDesc) {
		this.fDesc = fDesc;
	}
	public Double getfUnitPrice() {
		return fUnitPrice;
	}
	public void setfUnitPrice(Double fUnitPrice) {
		this.fUnitPrice = fUnitPrice;
	}
	public FoodItems() {
		super();
	}
	public FoodItems(Long fId,Long vid, String fDesc, Double fUnitPrice,String fName) {
		super();
		this.fId = fId;
		this.vid = vid;
		this.fDesc = fDesc;
		this.fUnitPrice = fUnitPrice;
		this.fName = fName ;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long fId;
	private String fName;
	private String fDesc;
	private Double fUnitPrice;
	private Long vid ;
}
