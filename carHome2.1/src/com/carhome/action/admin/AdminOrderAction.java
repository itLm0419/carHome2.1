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
	//0：未处理订单，1：已处理订单
	private String op;
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	//查询所有订单
	public String listOrders()
	{
		Integer size = orderService.listOrders(1, 999999, "all").size();
		maxPage = size%pageSize==0?size/10:size/10+1;
		orders = orderService.listOrders(pageNow, pageSize,op);
		return "list-success";
	}
	
	/**
	 * 显示某个订单的详细信息
	 * @return
	 */
	public String ShowOrderMess()
	{
		model = orderService.getEtityWithChild(model.getId());
		return "toShowOrderMessPage";
	}
	
	/**
	 * 管理员发货功能
	 * @return
	 */
	public String StartProducts()
	{
		model = orderService.getEtity(model.getId());
		model.setOrderStatus("已经发货");
		orderService.updateEntity(model);
		return "listOrdersAction";
	}
	/**
	 * 管理员取消发货功能
	 * @return
	 */
	public String CancelProducts()
	{
		model = orderService.getEtity(model.getId());
		model.setOrderStatus("等待发货");
		orderService.updateEntity(model);
		return "listOrdersAction";
	}
}
