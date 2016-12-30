package com.carhome.service;

import java.util.List;

import com.carhome.vo.CarBrand;
import com.carhome.vo.CarType;

public interface CarTypeService {
	//�õ����еİµϳ�
	public List<CarType> getCarsByBrand(String carBrandId);
	
	/**
	 * ���ݳ�Ʒ�Ƶõ����г�(���������)
	 */
	public List<CarType> getCarsByBrandWithChildren(Integer carBrandId) ;

	//�õ�����ĳ�ͺŵİµϳ����������(0_1)
	public String[] getCarsNumByType(Integer carBrandId,String carTypeName);
	
	/**
	 *  ���ݳ��ͺŵõ�����
	 */
	public CarType getCarTypeByTypeNum(Integer brandId,Integer carTypeId);
	/**
	 * ���ݳ���A3������г���A3�ĳ���
	 */
	public List<CarType> listCarTypeByName(String carName);
	
	/**
	 * ����ĳƷ�Ƶĳ��ĳ���
	 * @param carBrandId
	 * @param carTypes
	 */
	public void addCarTypesByBrand( List<CarType> carTypes);
	
	/**
	 * ���ݳ�Ʒ�Ʒ������г�ϵ��
	 * @param carBrandId
	 */
	public List<CarType> listCarTyeByBrand(Integer carBrandId);

	
	
	public void delCarType(Integer id);

	public void updateCarType(CarType model);

	public CarType getCarTypeById(Integer id);
	
}
