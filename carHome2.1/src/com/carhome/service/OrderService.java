package com.carhome.service;

import java.util.List;

import com.carhome.vo.Order;

public interface OrderService {
	public void saveEntity(Order order);
	public void updateEntity(Order order);
	//分页查询订单
	public List<Order> listOrders(Integer pageNow,Integer pageSize,String op);
	//获取到某个订单的详细信息
	public Order getEtityWithChild(Integer id);
	//得到某个订单
	public Order getEtity(Integer id);
}
