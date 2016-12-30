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
	 * 加入产品到购物车
	 */
	public void addProduct(Integer productId) {
		//查询当前购物车中是否有该商品
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie []cookies = request.getCookies();
		Integer nowNum = 1;
		int i = 0;
		for(;i<cookies.length;i++)
		{
			//System.out.println("name="+cookies[i].getName()+"value="+cookies[i].getValue());
			//找到购物车的商品，数量加1
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
		//循环完毕，没有找到已经购买的商品
		if(i == cookies.length)
		{
			//加入一个新的商品
			Cookie cookie = new Cookie(productId+"",nowNum+"");
			response.addCookie(cookie);
			System.out.println(cookie.getName()+" "+cookie.getValue());
		}
	}
	
	/**
	 * 根据产品Id得到产品
	 */
	public Product getProductById(int parseInt) {
		return productDaoImpl.getEntity(parseInt);
	}
}
