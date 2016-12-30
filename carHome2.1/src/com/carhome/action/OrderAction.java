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
	//������Ϣ
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * ȷ���ύ����
	 */
	public String doSubmitOrder()
	{
		//��ȡsession�е�user���󣬷ŵ�order��model����
		User user = (User) sessionMap.get("user");
		if(user == null)
		{
			message = "noUser";
			return "noUser-error";
		}
		//��ȡsession�е�goodModels���ŵ�orderMess��
		@SuppressWarnings("unchecked")
		List<GoodModel> goodModels = (List<GoodModel>) sessionMap.get("goodModels");
		Set<OrderProductMess> orderMess = new HashSet<OrderProductMess>();
		model.setUser(user);
		orderService.saveEntity(model);
		Double totalPrice = 0.0;
		for(GoodModel g : goodModels)
		{
			//������Ʒ���
			if(!productService.reduceProductStore(g.getProduct().getId(),g.getProductNum()))
			{
				message = new String("��ѡ�����Ʒ��"+g.getProduct().getName()+g.getProduct().getTypeNum()+
						"��治�㣡");
				return "toOrderFailAction";
			}
		}
		
		for(GoodModel g : goodModels)
		{
			//��GoodModel����ת���ɶ�������
			OrderProductMess o = new OrderProductMess();
			o.setOrder(model);
			o.setProduct(g.getProduct());
			o.setProductNum(g.getProductNum());
			o.setTotalPrice(g.getTotalPrice());
			//��ŵ����ݿ�
			orderProductMessService.saveEntity(o);
			orderMess.add(o);
			totalPrice += o.getTotalPrice();
		}
		model.setOrderTime(new Date());
		//ά�ֹ�����ϵ
		model.setOrderProductMesses(orderMess);
		//����״̬
		model.setOrderStatus("�ȴ�����");
		//�������
		model.setOrderNum(UUID.randomUUID().toString());
		//������Ʒ�ܼ۸�
		model.setTotalPrice(totalPrice);
		orderService.updateEntity(model);
		
		
		//��չ��ﳵ
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if(cookies.length > 0 && cookies != null ){
			int length = cookies.length;
			for(int i =0; i < length; i ++){
				cookies[i].setValue(null);
				cookies[i].setMaxAge(0);
				ServletActionContext.getResponse().addCookie(cookies[i]);
			}
		}
		//���session�е���Ʒ��Ϣ
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
