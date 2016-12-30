package com.carhome.vo.utilClass;

import java.util.ArrayList;
import java.util.List;

import com.carhome.vo.CarType;
import com.carhome.vo.Product;

public class MatchModel {
	/**
	 *  Ù–‘
	 */
	private CarType carType = new CarType();
	private List<Product> applyProducts;
	private List<Product> noApplyProducts;
	private List<String> firstApplyProductsTypeNums = new ArrayList<String>();
	private List<String> secondApplyProductsTypeNums = new ArrayList<String>();
	private List<String> thirdApplyProductsTypeNums = new ArrayList<String>();
	
	/**
	 * setter/getter
	 * @return
	 */
	public CarType getCarType() {
		return carType;
	}
	public List<String> getFirstApplyProductsTypeNums() {
		return firstApplyProductsTypeNums;
	}
	public void setFirstApplyProductsTypeNums(List<String> firstApplyProductsTypeNums) {
		this.firstApplyProductsTypeNums = firstApplyProductsTypeNums;
	}
	public List<String> getSecondApplyProductsTypeNums() {
		return secondApplyProductsTypeNums;
	}
	public void setSecondApplyProductsTypeNums(List<String> secondApplyProductsTypeNums) {
		this.secondApplyProductsTypeNums = secondApplyProductsTypeNums;
	}
	public List<String> getThirdApplyProductsTypeNums() {
		return thirdApplyProductsTypeNums;
	}
	public void setThirdApplyProductsTypeNums(List<String> thirdApplyProductsTypeNums) {
		this.thirdApplyProductsTypeNums = thirdApplyProductsTypeNums;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public List<Product> getApplyProducts() {
		return applyProducts;
	}
	public void setApplyProducts(List<Product> applyProducts) {
		this.applyProducts = applyProducts;
	}
	public List<Product> getNoApplyProducts() {
		return noApplyProducts;
	}
	public void setNoApplyProducts(List<Product> noApplyProducts) {
		this.noApplyProducts = noApplyProducts;
	}
}
