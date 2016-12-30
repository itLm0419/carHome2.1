package com.carhome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.ProductDaoImpl;
import com.carhome.service.ShoppingCarService;
import com.carhome.vo.Product;
@Service("shoppingCarService")
public class ShoppingCarServiceImpl implements ShoppingCarService {
	@Resource
	private ProductDaoImpl productDaoImpl;
	
	/**
	 * ���ݲ�Ʒid��ȡ��Ʒ
	 */
	public Product getProductById(Integer id) {
		return productDaoImpl.getEntity(id);
	}

}
