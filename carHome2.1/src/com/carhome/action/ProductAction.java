package com.carhome.action;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.service.CarTypeService;
import com.carhome.service.ProductService;
import com.carhome.utils.StringUtil;
import com.carhome.utils.ValidateUtil;
import com.carhome.vo.Product;
import com.carhome.vo.utilClass.CarTypeProductModel;
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	private static final long serialVersionUID = 941694618874589778L;
	
	@Resource
	private CarTypeService carTypeService;
	@Resource
	private ProductService productService;
	private Integer productId;
	private Integer carBrandId;
	private String carBrandName;
	public String getCarBrandName() {
		try {
			if(ValidateUtil.isValid(carBrandName))
			{
				return new String(carBrandName.getBytes("ISO8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return carBrandName;
	}
	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
	}
	private String carTypeName;
	private List<CarTypeProductModel> carTypeProductModels;
	private List<Product> oilProducts;
	public List<Product> getOilProducts() {
		return oilProducts;
	}
	public void setOilProducts(List<Product> oilProducts) {
		this.oilProducts = oilProducts;
	}

	/**
	 * 根据汽车配置返回推荐产品
	 */
	public String returnApplyProductsByCarConfig(){
		/**
		 * 第一步，获取当前型号汽车的编号数组
		 */
		String arr[] = carTypeService.getCarsNumByType(carBrandId, getCarTypeName());
		/**
		 * 第二步，根据数组查询出匹配的产品
		 */
		//1.根据数组（特定的车型）返回可以使用的产品
		carTypeProductModels = productService.getApplyProductsByCarConfig(arr);
		for(CarTypeProductModel c : carTypeProductModels)
		{
			System.out.println(c);
		}
		//2.随机推荐几种机油可供选择
		oilProducts = productService.getRandOilProducts();
	    return "toCarTypeProductsPage";
	}
	
	/**
	 * 根据产品ID返回产品详细信息
	 * @return
	 */
	public String returnProductInfoById(){
		model = productService.getProductInfoById(model.getId());
		return "toProductsPage";
	}
	
	
	
	//setter/getter
	public List<CarTypeProductModel> getCarTypeProductModels() {
		return carTypeProductModels;
	}
	public void setCarTypeProductModels(List<CarTypeProductModel> carTypeProductModels) {
		this.carTypeProductModels = carTypeProductModels;
	}
	public Integer getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}
	public String getCarTypeName() {
		if(ValidateUtil.isValid(carTypeName))
		{
			try {
				return new String(carTypeName.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return carTypeName;
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	/**
	 * 获取所有机油产品
	 * @return
	 */
	public String reurnAllOilProducts(){
		oilProducts =  productService.getAllOilProduct();
		return "toOilProductsPage";
	}

	
}