package com.carhome.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.CarBrandDaoImpl;
import com.carhome.service.CarBrandService;
import com.carhome.vo.CarBrand;

@Service
public class CarBrandServiceImpl implements CarBrandService {
	@Resource
	private CarBrandDaoImpl carBrandDaoImpl;
	
	public CarBrand getCarBrandById(Integer id) {
		return carBrandDaoImpl.getEntity(id);
	}
	public void addCarBrand(CarBrand model) {
		carBrandDaoImpl.saveEntity(model);
	}
	public void delCarBrand(Integer id) {
		carBrandDaoImpl.deleteEntity(carBrandDaoImpl.getEntity(id));
	}
	public void updateCarBrand(CarBrand model) {
		carBrandDaoImpl.updateEntity(model);
	}
	public List<CarBrand> listCarBrand() {
		return carBrandDaoImpl.findEntityByHQL("from CarBrand");
	}

}
