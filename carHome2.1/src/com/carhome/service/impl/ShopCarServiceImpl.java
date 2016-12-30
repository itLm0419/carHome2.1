package com.carhome.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.carhome.dao.impl.ProductDaoImpl;
import com.carhome.service.ShopCarService;
import com.carhome.vo.Product;

@Service
public class ShopCarServiceImpl implements ShopCarService {
	@Resource
	private ProductDaoImpl productDaoImpl;
	/**
	 * �����Ʒ�����ﳵ
	 */
	public void addProduct(Integer productId) {
		//��ѯ��ǰ���ﳵ���Ƿ��и���Ʒ
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie []cookies = request.getCookies();
		Integer nowNum = 1;
		int i = 0;
		for(;i<cookies.length;i++)
		{
			//System.out.println("name="+cookies[i].getName()+"value="+cookies[i].getValue());
			//�ҵ����ﳵ����Ʒ��������1
			if(cookies[i].getName().equals(productId+""))
			{
				//System.out.println(cookies[i].getName());
				//System.out.println(cookies[i].getValue());
				nowNum = Integer.parseInt(cookies[i].getValue())+1;
				Cookie cookie = new Cookie(productId+"",nowNum+"");
				System.out.println(cookie.getName()+" "+cookie.getValue());
				response.addCookie(cookie);
				break;
			}
		}
		//ѭ����ϣ�û���ҵ��Ѿ��������Ʒ
		if(i == cookies.length)
		{
			//����һ���µ���Ʒ
			Cookie cookie = new Cookie(productId+"",nowNum+"");
			response.addCookie(cookie);
			System.out.println(cookie.getName()+" "+cookie.getValue());
		}
	}
	
	/**
	 * ���ݲ�ƷId�õ���Ʒ
	 */
	public Product getProductById(int parseInt) {
		return productDaoImpl.getEntity(parseInt);
	}
}
