package com.carhome.vo;

public class Product {
	private Integer id;
	private String kind;
	private String name;
	private String typeNum;
	private String applyCars;
	private Double price;
	private Integer store;
	public Product()
	{
		this.id=9999;
	}
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", kind=" + kind + ", name=" + name + ", typeNum=" + typeNum + ", applyCars="
				+ applyCars + ", price=" + price + ", store=" + store + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApplyCars() {
		return applyCars;
	}
	public void setApplyCars(String applyCars) {
		this.applyCars = applyCars;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStore() {
		return store;
	}
	public void setStore(Integer store) {
		this.store = store;
	}
}
