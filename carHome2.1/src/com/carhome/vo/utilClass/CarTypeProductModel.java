package com.carhome.vo.utilClass;

import java.util.List;

import com.carhome.vo.CarType;
import com.carhome.vo.Product;

/**
 * @author Administrator
 *	这是 封装了车和推荐产品的一个模型
 */
public class CarTypeProductModel {
	private CarType car;
	private List<Product> carApplyProducts;
	
	public String toString() {
		return "CarTypeProductModel [car=" + car + ", carApplyProducts=" + carApplyProducts + "]";
	}
	
	
	public CarType getCar() {
		return car;
	}
	public void setCar(CarType car) {
		this.car = car;
	}
	public List<Product> getCarApplyProducts() {
		return carApplyProducts;
	}
	public void setCarApplyProducts(List<Product> carApplyProducts) {
		this.carApplyProducts = carApplyProducts;
	} 
	
}
