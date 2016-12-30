package com.carhome.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.CarTypeDaoImpl;
import com.carhome.dao.impl.ProductDaoImpl;
import com.carhome.service.CarTypeService;
import com.carhome.utils.StringUtil;
import com.carhome.utils.ValidateUtil;
import com.carhome.vo.CarType;
import com.carhome.vo.Product;
import com.carhome.vo.utilClass.CarTypeProductModel;
@Service("productService")
public class ProductServiceImpl implements com.carhome.service.ProductService {
	
	@Resource
	private ProductDaoImpl productDaoImpl;
	@Resource
	private CarTypeService carTypeService;
	
	private Integer carBrandId;
	private String  carTypeName;
	
	
	/**
	 * 通过汽车配置（某个车型 1_2）得到不匹配产品,不分页
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getNoApplyProductsByOneCarConfig(String carTypeNum) {
		String sql = "select * from _products where concat(',',applyCars,',') not like '%,"+carTypeNum+",%'";
		List<Product> list = productDaoImpl.executeSQLQuery(Product.class, sql);
		return list;
	}

	/**
	 * 通过id获取产品
	 */
	public Product getProductInfoById(Integer productId) {
		return productDaoImpl.getEntity(productId); 
	}

	/**
	 * 通过汽车配置（某种车型（A3、A4））获得推荐产品
	 */
	public List<CarTypeProductModel> getApplyProductsByCarConfig(String[] arr) {
		List<CarTypeProductModel> carTypeProductModels = new ArrayList<CarTypeProductModel>();
		for(String temp : arr)
		{
			CarTypeProductModel carTypeProductModel = new CarTypeProductModel();
			String []ids = StringUtil.String2arr(temp,"_");
			Integer brandId = Integer.parseInt(ids[0]);
			Integer carTypeId = Integer.parseInt(ids[1]);
			
			
			CarType carType = carTypeService.getCarTypeByTypeNum(brandId, carTypeId);
			carTypeProductModel.setCar(carType);
			carTypeProductModel.setCarApplyProducts(productDaoImpl.executeSQLQuery(Product.class, "select * from _products where concat(',',applyCars,',') like '%,"+temp+",%';"));
			carTypeProductModels.add(carTypeProductModel);
		}
		
		return carTypeProductModels;
	}
	
	/**
	 * 通过汽车配置（某个车型 1_2）得到匹配产品
	 */
	public List<Product> getApplyProductsByOneCarConfig(String carTypeNum) {
		String sql = "select * from _products where concat(',',applyCars,',') like '%,"+carTypeNum+",%'";
		List<Product> list = productDaoImpl.executeSQLQuery(Product.class, sql);
		return list;
	}

	/**
	 * 通过汽车配置（某个车型 1_2）得到不匹配产品
	 */
	public List<Product> getNoApplyProductsByOneCarConfig(String carTypeNum, String kind, String name, Integer first,
			Integer max) {
		String sql = "select * from _products where concat(',',applyCars,',') not like '%,"+carTypeNum+",%' and kind='"+kind+"'and name='"+name+"' order by typeNum";
		List<Product> list = productDaoImpl.executeSQLQuery(Product.class, sql,first,max);
		return list;
	}

	public Integer getCarBrandId() {
		return carBrandId;
	}
	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}
	public String getCarTypeName() {
		return carTypeName;
	}
	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}
	
	/**
	 * 随机查询出机油产品
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getRandOilProducts() {
		return productDaoImpl.executeSQLQuery(Product.class, "select * from _products where kind='机油' order by rand() limit 5");
	}
	/**
	 * 返回所有机油产品
	 */
	public List<Product> getAllOilProduct() {
		return productDaoImpl.findEntityByHQL("from Product product where product.kind = ?", "机油");
	}
	/**
	 * 给当前产品追加 一个 应用车型
	 */
	public void appendAppCar(Integer productId, String string) {
		Product product = productDaoImpl.getEntity(productId);
		if(ValidateUtil.isValid(product.getApplyCars()))
		{
			//有已应用的车型
			product.setApplyCars(product.getApplyCars()+","+string);
		}
		else {
			product.setApplyCars(string);
		}
		productDaoImpl.updateEntity(product);
	}
	/**
	 * 添加商品
	 * @return
	 */
	public void addProduct(Product model) {
		productDaoImpl.saveEntity(model);
	}

	/**
	 * 更新商品
	 * @return
	 */
	public void updateProduct(Product model) {
		productDaoImpl.saveOrUpdateEntity(model);
	}

	/**
	 * 删除商品
	 * @return
	 */
	public void deleteProductById(Integer id) {
		Product product = productDaoImpl.getEntity(id);
		productDaoImpl.deleteEntity(product);
	}

	/**
	 * 分类展示商品(分页)
	 * @return
	 */
	public List<Product> listProductByKind(String kind,String name, Integer first, Integer max) {
		return productDaoImpl.listEntityByPage(kind,name, first, max);
	}

	/**
	 * 查询产品种类
	 */
	public List<String> queryKind() {
		return  productDaoImpl.getKinds("select distinct kind from Product order by kind");
	}
	/**
	 * 查询品牌种类
	 */
	public List<String> queryName() {
		return  productDaoImpl.getKinds("select distinct name from Product order by name");
	}

	
	@Resource
	private CarTypeDaoImpl carTypeDaoImpl;
	/**
	 * 得到跟该产品匹配的所有车型
	 * @return
	 */
	public List<CarType> getAppCarTypeByProductId(Integer productId) {
		//1.得到appCarNums
		String appCarNums = productDaoImpl.getEntity(productId).getApplyCars();
		//2.根据appCarNums查出车型
		if(!ValidateUtil.isValid(appCarNums))
		{
			//appCarNums无效
			return null;
		}
		String BrandId_carTypeIds[] = StringUtil.String2arr(appCarNums, ",");
		List<CarType> carTypes = new ArrayList<CarType>();
		for(int i = 0;i<BrandId_carTypeIds.length;i++)
		{
			String[] target = StringUtil.String2arr(BrandId_carTypeIds[i], "_");
			CarType carType = (CarType) carTypeDaoImpl.executeSQLQueryObject(CarType.class, 
					"select * from _carTypes where id =? and brandId =?", 
					target[1],target[0]);
			//解决懒加载
			if(carType!=null)
			{
				carType.getBrand().getName();
				carTypes.add(carType);
			}
		}
		return carTypes;
	}

	/**
	 * 得到跟该产品不匹配的所有车型
	 * @return
	 */
	public List<CarType> getNoAppCarTypeByProductId(Integer id) {
		//1.得到appCarNums
		String appCarNums = productDaoImpl.getEntity(id).getApplyCars();
		List<CarType> list = null;
		//2.根据appCarNums查出车型
		if(!ValidateUtil.isValid(appCarNums))
		{
			list = carTypeDaoImpl.findEntityByHQL("from CarType");
			for(CarType c : list)
			{
				//解决懒加载
				c.getBrand().getName();
			}
			return list;
		}
		String BrandId_carTypeIds[] = StringUtil.String2arr(appCarNums, ",");
		List<CarType> carTypes = new ArrayList<CarType>();
		String sql = "select * from _carTypes where ";
		for(int i = 0;i<BrandId_carTypeIds.length;i++)
		{
			String[] target = StringUtil.String2arr(BrandId_carTypeIds[i], "_");
			 sql = sql + "(id != "+target[1]+" or brandId != "+target[0]+")";
			 if(i+1 != BrandId_carTypeIds.length)
			 {
				 //不是最后一次循环
				 sql = sql + " and ";
			 }
		}
		//System.out.println(sql);
		list = carTypeDaoImpl.executeSQLQuery(CarType.class,sql);
		for(CarType c : list)
		{
			//解决懒加载
			c.getBrand().getName();
		}
		return list;
	}
	/**
	 * 确认下单，减少商品库存
	 */
	public boolean reduceProductStore(Integer id, int productNum) {
		Product product = productDaoImpl.getEntity(id);
		Integer productStore = product.getStore();
		if(productStore >= productNum )
		{
			product.setStore(productStore-productNum);
			productDaoImpl.updateEntity(product);
			return true;
		}
		return false;
	}

	/**
	 * 根据产品名字获取产品Id
	 */
	public Integer getProductIdByTypeNum(String typeNum) {
		String hql = "from Product p where p.typeNum = ?";
		Product product = productDaoImpl.findEntityByHQL(hql, typeNum).get(0);
		return product.getId();
	}



}
