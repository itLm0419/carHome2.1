package com.carhome.action.admin;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.action.BaseAction;
import com.carhome.service.ProductService;
import com.carhome.utils.StringUtil;
import com.carhome.utils.ValidateUtil;
import com.carhome.vo.CarType;
import com.carhome.vo.Product;

@Controller
@Scope("prototype")
public class AdminProductAction extends BaseAction<Product> {
	private Map<String, Object> jsonMap = new HashMap<String, Object>();
	
	private String suggestion;
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	private Integer carBrandId;
	public Integer getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}
	private static final long serialVersionUID = -8901874628207021977L;
	@Resource
	private ProductService productService;

		private CarType newCarType;
	// 新增车型 能够匹配的产品的id集合
		private List<Integer> carAppProductIds;

		// 新增产品，能够匹配的所有车型字符串数组
		private String selectApplyCars[];
		private String removeCarType;
		private String productKind;
	
		private String productName;
		private Integer first = 0;
		private Integer max = 50;
		private Integer pageNow = 1;
		public Integer getPageNow() {
			return pageNow;
		}
		public void setPageNow(Integer pageNow) {
			this.pageNow = pageNow;
		}
		private Integer maxPage;
		public Integer getMaxPage() {
			return maxPage;
		}
		public void setMaxPage(Integer maxPage) {
			this.maxPage = maxPage;
		}
		private List<String> kinds;
		private List<Product> kindProducts;
		private List<CarType> appCarTypes;
		private List<CarType> noAppCarTypes;
		private List<Product> appProducts;
		private List<Product> noAppProducts;
		private String carTypeNum;
		
		public String getProductName() {
			if (ValidateUtil.isValid(productName)) {
				try {
					return new String(productName.getBytes("ISO8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
	
		
	/**
	 * 新增的车辆，匹配产品
	 */
	public String carSelectProduct() {
		for (Integer id : carAppProductIds) {
			productService.appendAppCar(id, carTypeNum);
		}
		return "carSelect-success";
	}
	

	/**
	 * 新增产品，匹配车型
	 */
	public String productSelectCar() {
		model = productService.getProductInfoById(model.getId());
		String target = StringUtil.arr2String(selectApplyCars);
		if(ValidateUtil.isValid(target))
		{
			if(ValidateUtil.isValid(model.getApplyCars()))
			{
				model.setApplyCars(model.getApplyCars()+","+target);
			}
			else {
				model.setApplyCars(target);
			}
		}
		
		productService.updateProduct(model);
		return "productSelect-success";
	}
	
	/**
	 * 车型移除匹配产品
	 */
	public String removeProductInCarType(){
		model = productService.getProductInfoById(model.getId());
		String applyCarNums = model.getApplyCars();
		if(ValidateUtil.isValid(applyCarNums))
		{
			String tar[] = StringUtil.String2arr(applyCarNums, ",");
			String target = "";
			for(int i=0;i<tar.length;i++)
			{
				System.out.println(removeCarType);
				if(!removeCarType.equals(tar[i]))
				{
					System.out.println(removeCarType+"="+tar[i]);
					target = target + tar[i];
				}
				if(i+1 != tar.length && i!=0)
				{
					target = target +",";
				}
			}
			model.setApplyCars(target);
			productService.updateProduct(model);
			return "removeAppProductFromCarType-success";
		}
		return "removeAppProductFromCarType-fail";
	}
	
	/**
	 * 产品移除匹配车型
	 */
	public String removeCarTypeInProduct()
	{
		model = productService.getProductInfoById(model.getId());
		String applyCarNums = model.getApplyCars();
		if(ValidateUtil.isValid(applyCarNums))
		{
			String tar[] = StringUtil.String2arr(applyCarNums, ",");
			String target = "";
			for(int i=0;i<tar.length;i++)
			{
				if(!removeCarType.equals(tar[i]))
				{
					System.out.println(removeCarType+"="+tar[i]);
					target = target + tar[i];
				}
				if(i+1 != tar.length && i!=0)
				{
					target = target +",";
				}
			}
			model.setApplyCars(target);
			productService.updateProduct(model);
			return "remove-success";
		}
		return "remove-fail";
	}
	

	/**
	 * 更新商品
	 */
	public String updateProduct() {
		productService.updateProduct(model);
		return "";
	}

	/**
	 * 删除商品
	 * 
	 * @return
	 */
	public String deleteProductById() {
		productService.deleteProductById(model.getId());
		return "";
	}

	/**
	 * 分类展示商品(分页)
	 * 
	 * @return
	 */
	public String listProductByKind() {
		first = (pageNow-1)*max;
		kindProducts = productService.listProductByKind(getProductKind(),getProductName(), first, max);
		Integer allProduct = productService.listProductByKind(getProductKind(), getProductName(),0, 9999999).size();
		maxPage = allProduct%max==0?allProduct/max:allProduct/max+1;
		return "listForProduct-success";
	}

	private List<String> names;
	public List<String> getNames() {
		return names;
	}


	public void setNames(List<String> names) {
		this.names = names;
	}


	/**
	 * 查询产品种类 和 品牌(筛选)
	 * @return
	 */
	public String selectKindForCar() {
		names = productService.queryName();
		kinds = productService.queryKind();
		return "queryKindForCar-success";
	}
	/**
	 * 查询产品种类 和 品牌(筛选)
	 * @return
	 */
	public String selectKindForProduct() {
		names = productService.queryName();
		kinds = productService.queryKind();
		return "queryKindForProduct-success";
	}
	
	/**
	 * 得到跟该产品匹配的所有车型
	 * @return
	 */
	public String queryAppCarTypeByProductId() {
		model = productService.getProductInfoById(model.getId());
		
		appCarTypes = productService.getAppCarTypeByProductId(model.getId());
		noAppCarTypes = productService.getNoAppCarTypeByProductId(model.getId());
		
		return "queryAppCarType-success";
	}
	
	/**
	 * 根据某个车型得到匹配产品
	 */
	public String returnApplyProductsByOneCarTypeNum()
	{
		first = (pageNow-1)*max;
		appProducts = productService.getApplyProductsByOneCarConfig(carTypeNum);
		noAppProducts = productService.getNoApplyProductsByOneCarConfig(carTypeNum,getProductKind(),getProductName(), 0, 999999999);
		return "returnAppProduct-success";
	}
	
	
	/**
	 * setter/getter
	 * @return
	 */
	public String getCarTypeNum() {
		return carTypeNum;
	}
	public void setCarTypeNum(String carTypeNum) {
		this.carTypeNum = carTypeNum;
	}
	public List<Integer> getCarAppProductIds() {
		return carAppProductIds;
	}
	public void setCarAppProductIds(List<Integer> carAppProductIds) {
		this.carAppProductIds = carAppProductIds;
	}
	public List<CarType> getNoAppCarTypes() {
		return noAppCarTypes;
	}
	public void setNoAppCarTypes(List<CarType> noAppCarTypes) {
		this.noAppCarTypes = noAppCarTypes;
	}
	public List<CarType> getAppCarTypes() {
		return appCarTypes;
	}
	public void setAppCarTypes(List<CarType> appCarTypes) {
		this.appCarTypes = appCarTypes;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public CarType getNewCarType() {
		return newCarType;
	}
	public void setNewCarType(CarType newCarType) {
		this.newCarType = newCarType;
	}
	public String[] getSelectApplyCars() {
		return selectApplyCars;
	}
	public void setSelectApplyCars(String[] selectApplyCars) {
		this.selectApplyCars = selectApplyCars;
	}
	public String getRemoveCarType() {
		return removeCarType;
	}
	public void setRemoveCarType(String removeCarType) {
		this.removeCarType = removeCarType;
	}
	public List<Product> getKindProducts() {
		return kindProducts;
	}
	public void setKindProducts(List<Product> kindProducts) {
		this.kindProducts = kindProducts;
	}
	public List<String> getKinds() {
		return kinds;
	}
	public void setKinds(List<String> kinds) {
		this.kinds = kinds;
	}
	public String getProductKind() {
		if (ValidateUtil.isValid(productKind)) {
			try {
				return new String(productKind.getBytes("ISO8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return productKind;
	}
	public void setProductKind(String productKind) {
		this.productKind = productKind;
	}
	public List<Product> getAppProducts() {
		return appProducts;
	}
	public void setAppProducts(List<Product> appProducts) {
		this.appProducts = appProducts;
	}
	public List<Product> getNoAppProducts() {
		return noAppProducts;
	}
	public void setNoAppProducts(List<Product> noAppProducts) {
		this.noAppProducts = noAppProducts;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	
	private List<Product> products; 
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/**
	 * 添加商品
	 * 
	 * @return
	 */
	public String addProduct() {
		for (Product product : products) {
			productService.addProduct(product);
		}
		return "toProductsListPage";
	}
	
	public String test()
	{
		System.out.println("ajax");
		suggestion = "{aa:aa}";
		return "ajax-success";
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

}
