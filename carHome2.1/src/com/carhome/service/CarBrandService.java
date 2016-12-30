package com.carhome.service;

import java.util.List;

import com.carhome.vo.CarBrand;

public interface CarBrandService {
	public CarBrand getCarBrandById(Integer id);

	public void addCarBrand(CarBrand model);

	public void delCarBrand(Integer id);

	public void updateCarBrand(CarBrand model);

	public List<CarBrand> listCarBrand();
	
	
}
