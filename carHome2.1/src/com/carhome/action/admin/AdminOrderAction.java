package com.carhome.action.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.action.BaseAction;
import com.carhome.service.OrderProductMessService;
import com.carhome.service.OrderService;
import com.carhome.vo.Order;
import com.carhome.vo.OrderProductMess;

@Controller
@Scope("prototype")
public class AdminOrderAction extends BaseAction<Order> {
	private static final long serialVersionUID = -2920211558641354054L;
	private List<Order> orders;
	@Autowired
	private OrderService orderService;
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	private Integer maxPage ;
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	private Integer pageNow = 1;
	private Integer pageSize = 10;
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	//0��δ��������1���Ѵ�����
	private String op;
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	//��ѯ���ж���
	public String listOrders()
	{
		Integer size = orderService.listOrders(1, 999999, "all").size();
		maxPage = size%pageSize==0?size/10:size/10+1;
		orders = orderService.listOrders(pageNow, pageSize,op);
		return "list-success";
	}
	
	/**
	 * ��ʾĳ����������ϸ��Ϣ
	 * @return
	 */
	public String ShowOrderMess()
	{
		model = orderService.getEtityWithChild(model.getId());
		return "toShowOrderMessPage";
	}
	
	/**
	 * ����Ա��������
	 * @return
	 */
	public String StartProducts()
	{
		model = orderService.getEtity(model.getId());
		model.setOrderStatus("�Ѿ�����");
		orderService.updateEntity(model);
		return "listOrdersAction";
	}
	/**
	 * ����Աȡ����������
	 * @return
	 */
	public String CancelProducts()
	{
		model = orderService.getEtity(model.getId());
		model.setOrderStatus("�ȴ�����");
		orderService.updateEntity(model);
		return "listOrdersAction";
	}
}
