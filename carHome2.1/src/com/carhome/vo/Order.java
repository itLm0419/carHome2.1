package com.carhome.vo;

import java.util.Date;
import java.util.Set;

public class Order {
	private Integer id;
	private String orderNum;
	private String orderStatus;
	private Date orderTime;
	//所有商品总价格
	private Double totalPrice;
	private User user;
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	private Set<OrderProductMess> orderProductMesses ;
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<OrderProductMess> getOrderProductMesses() {
		return orderProductMesses;
	}

	public void setOrderProductMesses(Set<OrderProductMess> orderProductMesses) {
		this.orderProductMesses = orderProductMesses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
