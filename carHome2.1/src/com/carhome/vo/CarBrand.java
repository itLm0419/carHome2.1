package com.carhome.vo;

import java.util.Set;

public class CarBrand {
	private Integer id;
	private String name;
	private String signUrl;
	private Set<CarType> carTypes;
	
	
	
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CarBrand [id=" + id + ", name=" + name + ", signUrl=" + signUrl + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public Set<CarType> getCarTypes() {
		return carTypes;
	}

	public void setCarTypes(Set<CarType> carTypes) {
		this.carTypes = carTypes;
	}

	
}
