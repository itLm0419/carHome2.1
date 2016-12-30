package com.carhome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.OrderProductMessDaoImpl;
import com.carhome.service.OrderProductMessService;
import com.carhome.vo.OrderProductMess;
@Service("orderProductMessService")
public class OrderProductMessServiceImpl implements OrderProductMessService {
	@Resource
	private OrderProductMessDaoImpl orderProductMessDaoImpl;
	public void saveEntity(OrderProductMess orderMess) {
		orderProductMessDaoImpl.saveEntity(orderMess);
	}

	public void updateEntity(OrderProductMess orderMess) {
		orderProductMessDaoImpl.updateEntity(orderMess);
	}
}
