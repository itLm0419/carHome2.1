package com.carhome.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.carhome.service.ShoppingCarService;
import com.carhome.utils.ValidateUtil;
import com.carhome.vo.Product;
import com.carhome.vo.User;
import com.carhome.vo.utilClass.GoodModel;
@Controller("shoppingCarAction")
@Scope("prototype")
public class ShoppingCarAction extends BaseAction<GoodModel> implements SessionAware{
	
	public static final int COOKIEALIVETIME = 60*60*24*365;
	
	private static final long serialVersionUID = 9051346639071816035L;
	@Resource
	private ShoppingCarService shoppingCarService;
	private Map<String, Object> jsonMap = new HashMap<String, Object>();
	private String productId;
	private Integer num;
	private List<GoodModel> goodModels ;

	private Map<String, Object> sessionMap;
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * 清空购物车(cookies)
	 * @return
	 */
	public String clearUpCar(){
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if(cookies.length > 0 && cookies != null ){
			int length = cookies.length;
			for(int i =0; i < length; i ++){
				cookies[i].setValue(null);
				cookies[i].setMaxAge(0);
				ServletActionContext.getResponse().addCookie(cookies[i]);
			}
		}
		return "toMyCartPage";
	}
	
	/**
	 * 加入购物车(cookie)
	 */
	public String addToCar(){
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		int length = cookies.length;
		Boolean notFound = true;
		if(length > 0){
			for(int i= 0; i < length; i ++){
				System.out.println(cookies[i].getName() + "有" + cookies[i].getValue() + "件");
				if(cookies[i].getName().equals("carProduct"+productId)){
					Integer newNum = num+Integer.parseInt(cookies[i].getValue());
					cookies[i].setValue(newNum+"");
					ServletActionContext.getResponse().addCookie(cookies[i]);
					notFound = false;
				}
			}
		}
		
		if(notFound){
			Cookie cookie = new Cookie("carProduct"+productId,num+"");
			cookie.setMaxAge(COOKIEALIVETIME);
			ServletActionContext.getResponse().addCookie(cookie);
		}
		jsonMap.put("productNum", cookies.length);
		return SUCCESS;
	}
	
	/**
	 * 移出购物车
	 */
	public String removeProductFromShoppingCarByProductId(){
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		int length = cookies.length;
		for(int i = 0; i < length; i ++){
			if(cookies[i].getName().equals("carProduct"+productId)){
				cookies[i].setValue(null);
				cookies[i].setMaxAge(0);
				ServletActionContext.getResponse().addCookie(cookies[i]);
			}
		}
		return "toShowShoppingCarAction";
	}
	
	
	/**
	 * 查看购物车
	 */
	public String showShoppingCar(){
			goodModels = new ArrayList<GoodModel>();
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			int length = cookies.length;
			for(int i = 0; i < length; i ++){
				if(cookies[i].getName().startsWith("carProduct")){
					Product product = new Product();
					GoodModel goodModel = new GoodModel();
					product = shoppingCarService.getProductById(Integer.parseInt((cookies[i].getName()).substring(10)));
					goodModel.setProduct(product);
					goodModel.setProductNum(Integer.parseInt(cookies[i].getValue()));
					goodModel.setTotalPrice(product.getPrice()*goodModel.getProductNum());
					goodModels.add(goodModel);
				}
			}
		return "toMyCartPage";
	}
	
	/**
	 * 得到所有的商品个数(未购买时，不在session中)
	 * @return
	 */
	public Integer returnTotalProductsNum()
	{
		int totalNum = 0;
		for(int i = 0;i<goodModels.size();i++)
		{
			totalNum += goodModels.get(i).getProductNum();
		}
		return totalNum;
	}
	
	/**
	 * 得到购物车所有商品总价(未购买时，不在session中)
	 * @return
	 */
	public double returnTotalProductsMoney()
	{
		double totalMoney = 0.0;
		for(int i = 0;i<goodModels.size();i++)
		{
			totalMoney += goodModels.get(i).getProductNum()*goodModels.get(i).getProduct().getPrice();
		}
		return totalMoney;
	}
	
	
	/**
	 * 更新购物车
	 */
	public String updateShoppingCarByProductId(){
		System.out.println("num="+num);
		System.out.println("productId="+productId);
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		int length = cookies.length;
		for(int i = 0 ; i < length; i ++){
			if(cookies[i].getName().equals("carProduct"+productId)){
				cookies[i].setValue(num+"");
				ServletActionContext.getResponse().addCookie(cookies[i]);
			}
		}
		return "toShowShoppingCarAction";
	}
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 确认购买，核对用户信息
	 */
	public String doBuyPruducts()
	{
		User user = (User) sessionMap.get("user");
		if(user == null)
		{
			//没有登录
			message = "noUser";
			return "noUser-error";
		}
		//获取购物车内容
		goodModels = new ArrayList<GoodModel>();
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		int length = cookies.length;
		for(int i = 0; i < length; i ++){
			if(cookies[i].getName().startsWith("carProduct")){
				Product product = new Product();
				GoodModel goodModel = new GoodModel();
				product = shoppingCarService.getProductById(Integer.parseInt(cookies[i].getName().substring(10)));
				goodModel.setProduct(product);
				goodModel.setProductNum(Integer.parseInt(cookies[i].getValue()));
				goodModel.setTotalPrice(product.getPrice()*goodModel.getProductNum());
				goodModels.add(goodModel);
			}
		}
		//确定购买，将商品放入session，等待提交订单
		sessionMap.put("goodModels", goodModels);
		return "toDoBuyProductsPage";
	}
	
	/**
	 * setter/getter
	 * @return
	 */
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public List<GoodModel> getGoodModels() {
		return goodModels;
	}
	public void setGoodModels(List<GoodModel> goodModels) {
		this.goodModels = goodModels;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	
	
}
