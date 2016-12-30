package com.carhome.action;

import javax.annotation.Resource;

import com.carhome.service.UserService;
import com.carhome.vo.User;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction<User> {

	private static final long serialVersionUID = 4846278032657255469L;
	@Resource
	private UserService userService;
	
	public String login(){
		model = userService.login(model);
		if(model!=null){
			ActionContext.getContext().getSession().put("user", model);
			return "toLoginSuccessPage";
		}
		addFieldError("login", "µÇÂ¼Ê§°Ü");
		return "toLoginFailedPage";
	}
}
