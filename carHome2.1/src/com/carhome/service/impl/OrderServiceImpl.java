package com.carhome.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.OrderDaoImpl;
import com.carhome.service.OrderService;
import com.carhome.utils.ValidateUtil;
import com.carhome.vo.Order;
import com.carhome.vo.OrderProductMess;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDaoImpl orderDaoImpl;
	public void saveEntity(Order order)
	{
		orderDaoImpl.saveEntity(order);
	}
	
	public void updateEntity(Order order)
	{
		orderDaoImpl.updateEntity(order);
	}

	public List<Order> listOrders(Integer pageNow, Integer pageSize,String op) {
		String sql = "select * from _orders";
		if(ValidateUtil.isValid(op))
		{
			if(op.equals("0"))
			{
				sql = sql+" where orderstatus = '等待发货'";
			}
			else if(op.equals("1")){
				sql = sql+" where orderstatus = '已经发货'";
			}
			else if(op.equals("all"))
			{
				sql = "select * from _orders";
			}
		}
		return orderDaoImpl.executeSQLQuery(Order.class, sql, (pageNow-1)*pageSize, pageSize);
	}
	/**
	 * 获取到某个订单的详细信息
	 */
	public Order getEtityWithChild(Integer id) {
		Order order = orderDaoImpl.getEntity(id);
		order.getUser().getName();
		for(OrderProductMess o : order.getOrderProductMesses())
		{
			o.getProduct().getPrice();
		}
		return order;
	}

	public Order getEtity(Integer id) {
		return orderDaoImpl.getEntity(id);
	}
	
}
