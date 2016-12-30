package com.carhome.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.CarTypeDaoImpl;
import com.carhome.service.CarTypeService;
import com.carhome.utils.StringUtil;
import com.carhome.vo.CarType;

@Service("carTypeService")
public class CarTypeServiceImpl implements CarTypeService {
	@Resource
	private CarTypeDaoImpl carTypeDao;

	/**
	 * 根据车品牌得到所有车
	 */
	public List<CarType> getCarsByBrand(String carBrandId) {
		return carTypeDao.findEntityByHQL("from CarType carType where carType.brand.id = ?", carBrandId);
	}

	/**
	 * 根据车品牌得到所有车(解决懒加载)
	 */
	public List<CarType> getCarsByBrandWithChildren(Integer carBrandId) {
		List<CarType> carTypes = carTypeDao.findEntityByHQL("from CarType carType where carType.brand.id = ?",carBrandId);
		for (CarType carType : carTypes) {
			carType.getBrand().getId();
		}

		// 去除车型名字重复的车型
		for (int i = 0; i < carTypes.size() - 1; i++) {
			for (int j = carTypes.size() - 1; j > i; j--) {
				if (carTypes.get(j).getName().equals(carTypes.get(i).getName())) {
					carTypes.remove(j);
				}
			}
		}

		return carTypes;
	}

	/**
	 * 根据车型得到所有的车号
	 */
	public String[] getCarsNumByType(Integer carBrandId, String carTypeName) {
		// 查询该车型的所有id
		List<CarType> carTypes = carTypeDao.getCarTypes(carBrandId, carTypeName);
		String temp = "";
		for (int i = 0; i < carTypes.size(); i++) {
			temp = temp + carTypes.get(i).getBrand().getId() + "_" + carTypes.get(i).getId() + ",";
		}
		return StringUtil.String2arr(temp, ",");
	}

	/**
	 * 根据车型号得到车型
	 */
	public CarType getCarTypeByTypeNum(Integer brandId, Integer carTypeId) {
		return carTypeDao.getCarTypeByTypeNum(brandId, carTypeId);
	}

	/**
	 *  增加某品牌的车的车类
	 * @param carBrandId
	 * @param carTypes
	 */
	public void addCarTypesByBrand(List<CarType> carTypes) {
		for (CarType carType : carTypes) {
			carTypeDao.saveEntity(carType);
		}
	}

	/**
	 * 根据车品牌返回所有车系列
	 */
	public List<CarType> listCarTyeByBrand(Integer carBrandId) {
		return carTypeDao.findEntityByHQL("from CarType c where c.brand.id= ?", carBrandId);
	}
	
	/**
	 * 根据车名A3获得所有车型A3的车型
	 */
	public List<CarType> listCarTypeByName(String carName)
	{
		return carTypeDao.findEntityByHQL("from CarType c where c.name = ?", carName);
	}

	
	
	public void delCarType(Integer id) {
		carTypeDao.deleteEntity(carTypeDao.getEntity(id));
	}

	public void updateCarType(CarType model) {
		carTypeDao.updateEntity(model);	
	}

	public CarType getCarTypeById(Integer id) {
		return carTypeDao.getEntity(id);
	}

}
