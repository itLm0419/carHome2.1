package com.carhome.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.action.BaseAction;
import com.carhome.service.CarBrandService;
import com.carhome.service.CarTypeService;
import com.carhome.vo.CarBrand;
import com.carhome.vo.CarType;
@Controller
@Scope("prototype")
public class AdminCarTypeAction extends BaseAction<CarType> {
	
	private static final long serialVersionUID = -5608853863036690289L;
	@Resource
	private CarTypeService carTypeService;
	
	private Integer carBrandId;
	private List<CarType> carTypes ;
	@Resource
	private CarBrandService carBrandService;
	/**
	 * 增加某品牌的车的车类(批量)
	 * @param carBrandId
	 * @param carTypes
	 * @return
	 */
	public String addCarTypesByBrand(List<CarType> carTypes){
		carTypeService.addCarTypesByBrand(carTypes);
		return "";
	}
	
	/**
	 * 根据车品牌返回所有车系列
	 * @param carBrandId
	 * @return
	 */
	public String listCarTyeByBrand(){
		carTypes=  carTypeService.listCarTyeByBrand(carBrandId);
		return "list-success";
	}

	
	public Integer getCarBrandId() {
		return carBrandId;
	}

	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}

	public List<CarType> getCarTypes() {
		return carTypes;
	}

	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}

	public String delCarType(){
		carTypeService.delCarType(model.getId());
		return "del-success";
	}
	public String updateCarType()
	{
		model.setBrand(carBrandService.getCarBrandById(carBrandId));
		carTypeService.updateCarType(model);
		return "update-success";
	}
	private List<Integer> brandId;
	/**
	 * 增加某品牌的车的车类(批量)
	 * @param carBrandId
	 * @param carTypes
	 * @return
	 */
	public String addCarTypesByBrand(){
		for (int i = 0; i < carTypes.size(); i ++) {
			CarBrand brand = carBrandService.getCarBrandById(brandId.get(i));
			carTypes.get(i).setBrand(brand);
		}
		carTypeService.addCarTypesByBrand(carTypes);
		return "add-success";
	}

	public List<Integer> getBrandId() {
		return brandId;
	}

	public void setBrandId(List<Integer> brandId) {
		this.brandId = brandId;
	}

	public String queryCarType()
	{
		model = carTypeService.getCarTypeById(model.getId());
		return "query-success";
	}

}
