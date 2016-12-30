package com.carhome.vo.utilClass;

import com.carhome.vo.Product;

public class GoodModel {
	private Product product;
	private int productNum;
	private Double totalPrice;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "GoodModel [product=" + product + ", productNum=" + productNum + ", totalPrice=" + totalPrice + "]";
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
