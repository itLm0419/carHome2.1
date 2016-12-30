package com.carhome.vo;

public class User {
	private int    id;
	private String userName;
	private String password;
	private String phoneNum;
	private String name;
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String shenFen;
	private String zhuangTai;
	private String chePai;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getShenFen() {
		return shenFen;
	}
	public void setShenFen(String shenFen) {
		this.shenFen = shenFen;
	}
	public String getZhuangTai() {
		return zhuangTai;
	}
	public void setZhuangTai(String zhuangTai) {
		this.zhuangTai = zhuangTai;
	}
	public String getChePai() {
		return chePai;
	}
	public void setChePai(String chePai) {
		this.chePai = chePai;
	}
	
	
	
}
