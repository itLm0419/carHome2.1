package com.carhome.service;

import java.util.List;

import com.carhome.vo.CarType;
import com.carhome.vo.Product;
import com.carhome.vo.utilClass.CarTypeProductModel;

public interface ProductService {
	/**
	 * �������õõ������Ƽ���Ʒ(ĳ������)
	 * @return
	 */
	public List<Product> getApplyProductsByOneCarConfig(String carTypeNum);
	/**
	 * ͨ���������ã�ĳ������ 1_2���õ���ƥ���Ʒ
	 */
	public List<Product> getNoApplyProductsByOneCarConfig(String carTypeNum,String kind,String name,Integer first,Integer max);
	
	/**
	 * ͨ��id��ȡ��Ʒ��Ϣ
	 * @param prioductId
	 * @return
	 */
	public Product getProductInfoById(Integer prioductId);

	/**
	 * ͨ���������û�ȡ�Ƽ���Ʒ
	 * @param arr
	 * @return
	 */
	public List<CarTypeProductModel> getApplyProductsByCarConfig(String[] arr);

	/**
	 * �����ȡ���Ͳ�Ʒ
	 * @return
	 */
	public List<Product> getRandOilProducts();

	/**
	 * �������л��Ͳ�Ʒ
	 */
	public List<Product> getAllOilProduct();

	/**
	 * ����ǰ��Ʒ׷�� һ�� Ӧ�ó���
	 */
	public void appendAppCar(Integer productId,String string);
	
	/**
	 * �����Ʒ
	 * @return
	 */
	public void addProduct(Product model);
	
	/**
	 * ������Ʒ
	 * @return
	 */
	public void updateProduct(Product model);

	/**
	 * ɾ����Ʒ
	 * @return
	 */
	public void deleteProductById(Integer id);

	/**
	 * ����չʾ��Ʒ(��ҳ)
	 * @return
	 */
	public List<Product> listProductByKind(String kind,String name, Integer first, Integer max);

	/**
	 * ��ѯ��Ʒ����
	 * @return
	 */
	public List<String> queryKind();
	/**
	 * ��ѯƷ������
	 * @return
	 */
	public List<String> queryName();
	/**
	 * �õ����ò�Ʒƥ������г���
	 * @return
	 */
	public List<CarType> getAppCarTypeByProductId(Integer productId);
	/**
	 * �õ����ò�Ʒ��ƥ������г���
	 * @return
	 */
	public List<CarType> getNoAppCarTypeByProductId(Integer id);
	
	/**
	 * ȷ���µ���������Ʒ���
	 * @param id
	 * @param productNum
	 */
	public boolean reduceProductStore(Integer id, int productNum);
	/**
	 * ͨ���������ã�ĳ������ 1_2���õ���ƥ���Ʒ,����ҳ
	 */
	public List<Product> getNoApplyProductsByOneCarConfig(String string);

	/**
	 * ���ݲ�Ʒ���ֻ�ȡ��ƷId
	 */
	public Integer getProductIdByTypeNum(String typeNum);

}
