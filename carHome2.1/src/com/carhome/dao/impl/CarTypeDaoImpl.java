package com.carhome.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carhome.vo.CarType;
@Repository("carTypeDao")
public class CarTypeDaoImpl extends BaseDaoImpl<CarType> {
	//���ݳ������ֲ�ѯ����carTypes
	public List<CarType> getCarTypes(Integer brandId,String carTypeName)
	{
		String hql = "from CarType c where c.name = ? and c.brand.id =? order by c.typeNum,c.airOut,c.startTime desc";
		List<CarType> carTypes = this.findEntityByHQL(hql, carTypeName,brandId);
		return carTypes;
	}

	/**
	 * ���ݳ��ͺ� ��ѯ ���Ͷ��� 
	 */
	public CarType getCarTypeByTypeNum(Integer brandId,Integer carTypeId) {
		String hql = "from CarType c where c.brand.id = ? and c.id =?";
		return (CarType) this.uniqueResult(hql, brandId,carTypeId);
	}

}
