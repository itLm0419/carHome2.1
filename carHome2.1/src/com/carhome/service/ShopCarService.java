package com.carhome.service;

import com.carhome.vo.Product;

public interface ShopCarService {
	//���빺�ﳵ��Ʒ
	public void addProduct(Integer productId);
	//��ѯ���ﳵ
	public Product getProductById(int parseInt);
}
