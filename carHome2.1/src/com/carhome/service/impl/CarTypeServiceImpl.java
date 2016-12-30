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
	 * ���ݳ�Ʒ�Ƶõ����г�
	 */
	public List<CarType> getCarsByBrand(String carBrandId) {
		return carTypeDao.findEntityByHQL("from CarType carType where carType.brand.id = ?", carBrandId);
	}

	/**
	 * ���ݳ�Ʒ�Ƶõ����г�(���������)
	 */
	public List<CarType> getCarsByBrandWithChildren(Integer carBrandId) {
		List<CarType> carTypes = carTypeDao.findEntityByHQL("from CarType carType where carType.brand.id = ?",carBrandId);
		for (CarType carType : carTypes) {
			carType.getBrand().getId();
		}

		// ȥ�����������ظ��ĳ���
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
	 * ���ݳ��͵õ����еĳ���
	 */
	public String[] getCarsNumByType(Integer carBrandId, String carTypeName) {
		// ��ѯ�ó��͵�����id
		List<CarType> carTypes = carTypeDao.getCarTypes(carBrandId, carTypeName);
		String temp = "";
		for (int i = 0; i < carTypes.size(); i++) {
			temp = temp + carTypes.get(i).getBrand().getId() + "_" + carTypes.get(i).getId() + ",";
		}
		return StringUtil.String2arr(temp, ",");
	}

	/**
	 * ���ݳ��ͺŵõ�����
	 */
	public CarType getCarTypeByTypeNum(Integer brandId, Integer carTypeId) {
		return carTypeDao.getCarTypeByTypeNum(brandId, carTypeId);
	}

	/**
	 *  ����ĳƷ�Ƶĳ��ĳ���
	 * @param carBrandId
	 * @param carTypes
	 */
	public void addCarTypesByBrand(List<CarType> carTypes) {
		for (CarType carType : carTypes) {
			carTypeDao.saveEntity(carType);
		}
	}

	/**
	 * ���ݳ�Ʒ�Ʒ������г�ϵ��
	 */
	public List<CarType> listCarTyeByBrand(Integer carBrandId) {
		return carTypeDao.findEntityByHQL("from CarType c where c.brand.id= ?", carBrandId);
	}
	
	/**
	 * ���ݳ���A3������г���A3�ĳ���
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
