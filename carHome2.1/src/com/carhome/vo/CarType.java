package com.carhome.vo;

import java.util.Date;

public class CarType {
	private Integer id;
	private String name;
	private String airOut;
	private String carPicUrl;
	private String typeNum;
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	private Date startTime;
	private Date endTime;
	private CarBrand brand;
	public Date getStartTime() {
		return startTime;
	}
	@Override
	public String toString() {
		return "CarType [id=" + id + ", name=" + name + ", airOut=" + airOut + ", carPicUrl=" + carPicUrl + ", typeNum="
				+ typeNum + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getId() {
		return id;
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
	public String getAirOut() {
		return airOut;
	}
	public void setAirOut(String airOut) {
		this.airOut = airOut;
	}
	public String getCarPicUrl() {
		return carPicUrl;
	}
	public void setCarPicUrl(String carPicUrl) {
		this.carPicUrl = carPicUrl;
	}
	public CarBrand getBrand() {
		return brand;
	}
	public void setBrand(CarBrand brand) {
		this.brand = brand;
	}
	
	
}
