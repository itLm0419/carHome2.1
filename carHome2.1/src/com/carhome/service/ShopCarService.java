package com.carhome.service;

import com.carhome.vo.Product;

public interface ShopCarService {
	//加入购物车产品
	public void addProduct(Integer productId);
	//查询购物车
	public Product getProductById(int parseInt);
}
