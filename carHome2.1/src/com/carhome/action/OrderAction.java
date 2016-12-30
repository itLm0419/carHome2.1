package com.carhome.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.service.OrderProductMessService;
import com.carhome.service.OrderService;
import com.carhome.service.ProductService;
import com.carhome.vo.Order;
import com.carhome.vo.OrderProductMess;
import com.carhome.vo.User;
import com.carhome.vo.utilClass.GoodModel;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends BaseAction<Order> implements SessionAware{

	private static final long serialVersionUID = -6999057178690860102L;
	private Map<String, Object> sessionMap;
	@Resource
	private OrderService orderService;
	@Resource
	private OrderProductMessService orderProductMessService;
	@Resource
	private ProductService productService;
	//错误信息
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 确认提交订单
	 */
	public String doSubmitOrder()
	{
		//获取session中的user对象，放到order（model）中
		User user = (User) sessionMap.get("user");
		if(user == null)
		{
			message = "noUser";
			return "noUser-error";
		}
		//获取session中的goodModels，放到orderMess中
		@SuppressWarnings("unchecked")
		List<GoodModel> goodModels = (List<GoodModel>) sessionMap.get("goodModels");
		Set<OrderProductMess> orderMess = new HashSet<OrderProductMess>();
		model.setUser(user);
		orderService.saveEntity(model);
		Double totalPrice = 0.0;
		for(GoodModel g : goodModels)
		{
			//减少商品库存
			if(!productService.reduceProductStore(g.getProduct().getId(),g.getProductNum()))
			{
				message = new String("您选择的商品："+g.getProduct().getName()+g.getProduct().getTypeNum()+
						"库存不足！");
				return "toOrderFailAction";
			}
		}
		
		for(GoodModel g : goodModels)
		{
			//将GoodModel对象转换成订单对象
			OrderProductMess o = new OrderProductMess();
			o.setOrder(model);
			o.setProduct(g.getProduct());
			o.setProductNum(g.getProductNum());
			o.setTotalPrice(g.getTotalPrice());
			//存放到数据库
			orderProductMessService.saveEntity(o);
			orderMess.add(o);
			totalPrice += o.getTotalPrice();
		}
		model.setOrderTime(new Date());
		//维持关联关系
		model.setOrderProductMesses(orderMess);
		//订单状态
		model.setOrderStatus("等待发货");
		//订单编号
		model.setOrderNum(UUID.randomUUID().toString());
		//订单商品总价格
		model.setTotalPrice(totalPrice);
		orderService.updateEntity(model);
		
		
		//清空购物车
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if(cookies.length > 0 && cookies != null ){
			int length = cookies.length;
			for(int i =0; i < length; i ++){
				cookies[i].setValue(null);
				cookies[i].setMaxAge(0);
				ServletActionContext.getResponse().addCookie(cookies[i]);
			}
		}
		//清除session中的商品信息
		return "toOrderSuccessAction";
	}

	public String orderSuccess()
	{
		return "toOrderSuccessPage";
	}
	public String orderFail()
	{
		return "toOrderFailPage";
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
}
