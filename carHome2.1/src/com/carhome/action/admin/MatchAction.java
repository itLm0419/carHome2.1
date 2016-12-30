package com.carhome.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.action.BaseAction;
import com.carhome.service.CarTypeService;
import com.carhome.service.ProductService;
import com.carhome.utils.ValidateUtil;
import com.carhome.vo.CarType;
import com.carhome.vo.Product;
import com.carhome.vo.utilClass.MatchModel;

@Controller
@Scope("prototype")
public class MatchAction {
	private String input;
	private List<String> keywords;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	private static final long serialVersionUID = -8358533750812749903L;
	@Resource
	private CarTypeService carTypeService;
	@Resource
	private ProductService productService;
	// 车品牌ID
	private Integer carBrandId;
	// 模型list
	private List<MatchModel> matchModels = new ArrayList<MatchModel>();
	
	/**
	 * 给车型匹配产品
	 */
	public String matchProductsForCarTypes() {
		List<CarType> carTypes = carTypeService.listCarTypeByName("A4");
		for (CarType carType : carTypes) {
			List<Product> applyProducts = productService
					.getApplyProductsByOneCarConfig(carType.getBrand().getId() + "_" + carType.getId());
			List<Product> noApplyProducts = productService
					.getNoApplyProductsByOneCarConfig(carType.getBrand().getId() + "_" + carType.getId());
			MatchModel matchModel = new MatchModel();
			matchModel.setCarType(carType);
			matchModel.setApplyProducts(applyProducts);
			matchModel.setNoApplyProducts(noApplyProducts);
			matchModels.add(matchModel);
		}
		return "toMatchPage";
	}

	public String ajaxGetProduct() {
			List<Product> noApplyProducts = productService
					.getNoApplyProductsByOneCarConfig("1_1");
			// ajax
			keywords = new ArrayList<String>();
			for (Product p : noApplyProducts) {
				if (p.getTypeNum().replace(" ", "").contains(input)) {
					keywords.add(p.getName()+p.getTypeNum());
				}
			}
		return "success";
	}

		/**
		 * 提交匹配
		 */
		public String submitMatching(){
			List<String> productsTypeNums = new ArrayList<String>();
			for (MatchModel matchModel : matchModels) {
				//将三种产品的型号集合合成一个集合
				productsTypeNums.addAll(matchModel.getFirstApplyProductsTypeNums());
				productsTypeNums.addAll(matchModel.getSecondApplyProductsTypeNums());
				productsTypeNums.addAll(matchModel.getThirdApplyProductsTypeNums());
				for (String typeNum : productsTypeNums) {
					if(ValidateUtil.isValid(typeNum))
					{
						Integer productId = productService.getProductIdByTypeNum(typeNum);
						carBrandId = carTypeService.getCarTypeById(matchModel.getCarType().getId()).getBrand().getId();
						productService.appendAppCar(productId, carBrandId + "_" + matchModel.getCarType().getId());
					}
				}
				productsTypeNums = new ArrayList<String>();
			}
			return "toMatchProductsForCarTypes";
		}

	/**
	 * setter/getter
	 */
	public Integer getCarBrandId() {
		return carBrandId;
	}

	public List<MatchModel> getMatchModels() {
		return matchModels;
	}

	public void setMatchModels(List<MatchModel> matchModels) {
		this.matchModels = matchModels;
	}

	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}

}
