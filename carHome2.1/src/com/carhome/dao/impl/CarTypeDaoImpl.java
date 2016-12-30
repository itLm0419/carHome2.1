package com.carhome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carhome.vo.CarType;
@Repository("carTypeDao")
public class CarTypeDaoImpl extends BaseDaoImpl<CarType> {
	//根据车型名字查询所有carTypes
	public List<CarType> getCarTypes(Integer brandId,String carTypeName)
	{
		String hql = "from CarType c where c.name = ? and c.brand.id =? order by c.typeNum,c.airOut,c.startTime desc";
		List<CarType> carTypes = this.findEntityByHQL(hql, carTypeName,brandId);
		return carTypes;
	}

	/**
	 * 根据车型号 查询 车型对象 
	 */
	public CarType getCarTypeByTypeNum(Integer brandId,Integer carTypeId) {
		String hql = "from CarType c where c.brand.id = ? and c.id =?";
		return (CarType) this.uniqueResult(hql, brandId,carTypeId);
	}

}
