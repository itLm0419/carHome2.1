package com.carhome.service;

import java.util.List;

import com.carhome.vo.CarType;
import com.carhome.vo.Product;
import com.carhome.vo.utilClass.CarTypeProductModel;

public interface ProductService {
	/**
	 * 根据配置得到所有推荐产品(某个车型)
	 * @return
	 */
	public List<Product> getApplyProductsByOneCarConfig(String carTypeNum);
	/**
	 * 通过汽车配置（某个车型 1_2）得到不匹配产品
	 */
	public List<Product> getNoApplyProductsByOneCarConfig(String carTypeNum,String kind,String name,Integer first,Integer max);
	
	/**
	 * 通过id获取产品信息
	 * @param prioductId
	 * @return
	 */
	public Product getProductInfoById(Integer prioductId);

	/**
	 * 通过汽车配置获取推荐产品
	 * @param arr
	 * @return
	 */
	public List<CarTypeProductModel> getApplyProductsByCarConfig(String[] arr);

	/**
	 * 随机获取机油产品
	 * @return
	 */
	public List<Product> getRandOilProducts();

	/**
	 * 返回所有机油产品
	 */
	public List<Product> getAllOilProduct();

	/**
	 * 给当前产品追加 一个 应用车型
	 */
	public void appendAppCar(Integer productId,String string);
	
	/**
	 * 添加商品
	 * @return
	 */
	public void addProduct(Product model);
	
	/**
	 * 更新商品
	 * @return
	 */
	public void updateProduct(Product model);

	/**
	 * 删除商品
	 * @return
	 */
	public void deleteProductById(Integer id);

	/**
	 * 分类展示商品(分页)
	 * @return
	 */
	public List<Product> listProductByKind(String kind,String name, Integer first, Integer max);

	/**
	 * 查询产品种类
	 * @return
	 */
	public List<String> queryKind();
	/**
	 * 查询品牌种类
	 * @return
	 */
	public List<String> queryName();
	/**
	 * 得到跟该产品匹配的所有车型
	 * @return
	 */
	public List<CarType> getAppCarTypeByProductId(Integer productId);
	/**
	 * 得到跟该产品不匹配的所有车型
	 * @return
	 */
	public List<CarType> getNoAppCarTypeByProductId(Integer id);
	
	/**
	 * 确认下单，减少商品库存
	 * @param id
	 * @param productNum
	 */
	public boolean reduceProductStore(Integer id, int productNum);
	/**
	 * 通过汽车配置（某个车型 1_2）得到不匹配产品,不分页
	 */
	public List<Product> getNoApplyProductsByOneCarConfig(String string);

	/**
	 * 根据产品名字获取产品Id
	 */
	public Integer getProductIdByTypeNum(String typeNum);

}
