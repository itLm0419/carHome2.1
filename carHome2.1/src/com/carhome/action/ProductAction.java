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
	 * �����������÷����Ƽ���Ʒ
	 */
	public String returnApplyProductsByCarConfig(){
		/**
		 * ��һ������ȡ��ǰ�ͺ������ı������
		 */
		String arr[] = carTypeService.getCarsNumByType(carBrandId, getCarTypeName());
		/**
		 * �ڶ��������������ѯ��ƥ��Ĳ�Ʒ
		 */
		//1.�������飨�ض��ĳ��ͣ����ؿ���ʹ�õĲ�Ʒ
		carTypeProductModels = productService.getApplyProductsByCarConfig(arr);
		for(CarTypeProductModel c : carTypeProductModels)
		{
			System.out.println(c);
		}
		//2.����Ƽ����ֻ��Ϳɹ�ѡ��
		oilProducts = productService.getRandOilProducts();
	    return "toCarTypeProductsPage";
	}
	
	/**
	 * ���ݲ�ƷID���ز�Ʒ��ϸ��Ϣ
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
	 * ��ȡ���л��Ͳ�Ʒ
	 * @return
	 */
	public String reurnAllOilProducts(){
		oilProducts =  productService.getAllOilProduct();
		return "toOilProductsPage";
	}

	
}