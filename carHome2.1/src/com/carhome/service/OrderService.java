package com.carhome.service;

import java.util.List;

import com.carhome.vo.Order;

public interface OrderService {
	public void saveEntity(Order order);
	public void updateEntity(Order order);
	//��ҳ��ѯ����
	public List<Order> listOrders(Integer pageNow,Integer pageSize,String op);
	//��ȡ��ĳ����������ϸ��Ϣ
	public Order getEtityWithChild(Integer id);
	//�õ�ĳ������
	public Order getEtity(Integer id);
}
