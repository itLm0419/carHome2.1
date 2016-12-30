package com.carhome.action.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.action.BaseAction;
import com.carhome.service.CarBrandService;
import com.carhome.vo.CarBrand;
@Controller
@Scope("prototype")
public class AdminCarBrandAction extends BaseAction<CarBrand> {
	private Integer carBrandId;
	public Integer getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}

	private static final long serialVersionUID = -7859607227330042943L;
	@Resource
	private CarBrandService carBrandService;
	private List<CarBrand> carBrands;
	//添加品牌
	public String addCarBrand(){
		carBrandService.addCarBrand(model);
		return "add-success";
	}
	//查询品牌
	public String queryCarBrand()
	{
		this.model = carBrandService.getCarBrandById(model.getId());
		return "query-success";
	}
	
	public String delCarBrand(){
		carBrandService.delCarBrand(model.getId());
		return "del-success";
	}

	public List<CarBrand> getCarBrands() {
		return carBrands;
	}

	public void setCarBrands(List<CarBrand> carBrands) {
		this.carBrands = carBrands;
	}

	public String updateCarBrand(){
		carBrandService.updateCarBrand(model);
		return "update-success";
	}
	
	//返回一个list<CarBrand>
	public String listCarBrand(){
		carBrands = carBrandService.listCarBrand();
		return "list-success";
	}

}
