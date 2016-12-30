package com.carhome.service;

import java.util.List;

import com.carhome.vo.CarBrand;
import com.carhome.vo.CarType;

public interface CarTypeService {
	//得到所有的奥迪车
	public List<CarType> getCarsByBrand(String carBrandId);
	
	/**
	 * 根据车品牌得到所有车(解决懒加载)
	 */
	public List<CarType> getCarsByBrandWithChildren(Integer carBrandId) ;

	//得到所有某型号的奥迪车的序号数组(0_1)
	public String[] getCarsNumByType(Integer carBrandId,String carTypeName);
	
	/**
	 *  根据车型号得到车型
	 */
	public CarType getCarTypeByTypeNum(Integer brandId,Integer carTypeId);
	/**
	 * 根据车名A3获得所有车型A3的车型
	 */
	public List<CarType> listCarTypeByName(String carName);
	
	/**
	 * 增加某品牌的车的车类
	 * @param carBrandId
	 * @param carTypes
	 */
	public void addCarTypesByBrand( List<CarType> carTypes);
	
	/**
	 * 根据车品牌返回所有车系列
	 * @param carBrandId
	 */
	public List<CarType> listCarTyeByBrand(Integer carBrandId);

	
	
	public void delCarType(Integer id);

	public void updateCarType(CarType model);

	public CarType getCarTypeById(Integer id);
	
}
