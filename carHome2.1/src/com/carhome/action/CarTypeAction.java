package com.carhome.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.service.CarBrandService;
import com.carhome.service.CarTypeService;
import com.carhome.vo.CarBrand;
import com.carhome.vo.CarType;
@Controller
@Scope("prototype")
public class CarTypeAction extends BaseAction<CarType> {

	private static final long serialVersionUID = 6492298654249965378L;
	
	@Resource
	private CarTypeService carTypeService;
	@Resource
	private CarBrandService carBrandService;
	
	private List cars;
	private Integer carBrandId;
	private CarBrand carBrand;
	public CarBrand getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	/**
	 * 根据车品牌得到该品牌所有车
	 * @return
	 */
	public String selectBrand(){
		carBrand = carBrandService.getCarBrandById(carBrandId);
		cars = carTypeService.getCarsByBrandWithChildren(carBrandId);
		return "toCarTypePage";
	}
	
	//setter/getter
	public List getCars() {
		return cars;
	}
	public void setCars(List cars) {
		this.cars = cars;
	}
	public Integer getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}

}
