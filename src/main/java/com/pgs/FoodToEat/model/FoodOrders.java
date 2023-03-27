package com.pgs.FoodToEat.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;





@Entity
@Table(name="FoodOrders")
@IdClass(CompositeKey.class)
public class FoodOrders {

	
	@Id
	private Long cid;
	@Id
	private Long vid ;
	@Id
	private Long fid ;
	private LocalDateTime orderDate;
	private String orderStatus;
	private String remark;
	private Integer quantity ;
	private Double totalPrice ;
	public FoodOrders(Long cid, Long vid, Long fid, LocalDateTime orderDate, String orderStatus, String remark,
			Integer quantity, Double totalPrice) {
		super();
		this.cid = cid;
		this.vid = vid;
		this.fid = fid;
		this.orderDate = LocalDateTime.now();
		this.orderStatus = orderStatus;
		this.remark = remark;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public FoodOrders() {}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = LocalDateTime.now();
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice ) {
		this.totalPrice = (totalPrice * this.quantity);
	} 
	
	
}
