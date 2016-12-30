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
	 * ͨ���������ã�ĳ������ 1_2���õ���ƥ���Ʒ,����ҳ
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getNoApplyProductsByOneCarConfig(String carTypeNum) {
		String sql = "select * from _products where concat(',',applyCars,',') not like '%,"+carTypeNum+",%'";
		List<Product> list = productDaoImpl.executeSQLQuery(Product.class, sql);
		return list;
	}

	/**
	 * ͨ��id��ȡ��Ʒ
	 */
	public Product getProductInfoById(Integer productId) {
		return productDaoImpl.getEntity(productId); 
	}

	/**
	 * ͨ���������ã�ĳ�ֳ��ͣ�A3��A4��������Ƽ���Ʒ
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
	 * ͨ���������ã�ĳ������ 1_2���õ�ƥ���Ʒ
	 */
	public List<Product> getApplyProductsByOneCarConfig(String carTypeNum) {
		String sql = "select * from _products where concat(',',applyCars,',') like '%,"+carTypeNum+",%'";
		List<Product> list = productDaoImpl.executeSQLQuery(Product.class, sql);
		return list;
	}

	/**
	 * ͨ���������ã�ĳ������ 1_2���õ���ƥ���Ʒ
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
	 * �����ѯ�����Ͳ�Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getRandOilProducts() {
		return productDaoImpl.executeSQLQuery(Product.class, "select * from _products where kind='����' order by rand() limit 5");
	}
	/**
	 * �������л��Ͳ�Ʒ
	 */
	public List<Product> getAllOilProduct() {
		return productDaoImpl.findEntityByHQL("from Product product where product.kind = ?", "����");
	}
	/**
	 * ����ǰ��Ʒ׷�� һ�� Ӧ�ó���
	 */
	public void appendAppCar(Integer productId, String string) {
		Product product = productDaoImpl.getEntity(productId);
		if(ValidateUtil.isValid(product.getApplyCars()))
		{
			//����Ӧ�õĳ���
			product.setApplyCars(product.getApplyCars()+","+string);
		}
		else {
			product.setApplyCars(string);
		}
		productDaoImpl.updateEntity(product);
	}
	/**
	 * �����Ʒ
	 * @return
	 */
	public void addProduct(Product model) {
		productDaoImpl.saveEntity(model);
	}

	/**
	 * ������Ʒ
	 * @return
	 */
	public void updateProduct(Product model) {
		productDaoImpl.saveOrUpdateEntity(model);
	}

	/**
	 * ɾ����Ʒ
	 * @return
	 */
	public void deleteProductById(Integer id) {
		Product product = productDaoImpl.getEntity(id);
		productDaoImpl.deleteEntity(product);
	}

	/**
	 * ����չʾ��Ʒ(��ҳ)
	 * @return
	 */
	public List<Product> listProductByKind(String kind,String name, Integer first, Integer max) {
		return productDaoImpl.listEntityByPage(kind,name, first, max);
	}

	/**
	 * ��ѯ��Ʒ����
	 */
	public List<String> queryKind() {
		return  productDaoImpl.getKinds("select distinct kind from Product order by kind");
	}
	/**
	 * ��ѯƷ������
	 */
	public List<String> queryName() {
		return  productDaoImpl.getKinds("select distinct name from Product order by name");
	}

	
	@Resource
	private CarTypeDaoImpl carTypeDaoImpl;
	/**
	 * �õ����ò�Ʒƥ������г���
	 * @return
	 */
	public List<CarType> getAppCarTypeByProductId(Integer productId) {
		//1.�õ�appCarNums
		String appCarNums = productDaoImpl.getEntity(productId).getApplyCars();
		//2.����appCarNums�������
		if(!ValidateUtil.isValid(appCarNums))
		{
			//appCarNums��Ч
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
			//���������
			if(carType!=null)
			{
				carType.getBrand().getName();
				carTypes.add(carType);
			}
		}
		return carTypes;
	}

	/**
	 * �õ����ò�Ʒ��ƥ������г���
	 * @return
	 */
	public List<CarType> getNoAppCarTypeByProductId(Integer id) {
		//1.�õ�appCarNums
		String appCarNums = productDaoImpl.getEntity(id).getApplyCars();
		List<CarType> list = null;
		//2.����appCarNums�������
		if(!ValidateUtil.isValid(appCarNums))
		{
			list = carTypeDaoImpl.findEntityByHQL("from CarType");
			for(CarType c : list)
			{
				//���������
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
				 //�������һ��ѭ��
				 sql = sql + " and ";
			 }
		}
		//System.out.println(sql);
		list = carTypeDaoImpl.executeSQLQuery(CarType.class,sql);
		for(CarType c : list)
		{
			//���������
			c.getBrand().getName();
		}
		return list;
	}
	/**
	 * ȷ���µ���������Ʒ���
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
	 * ���ݲ�Ʒ���ֻ�ȡ��ƷId
	 */
	public Integer getProductIdByTypeNum(String typeNum) {
		String hql = "from Product p where p.typeNum = ?";
		Product product = productDaoImpl.findEntityByHQL(hql, typeNum).get(0);
		return product.getId();
	}



}
