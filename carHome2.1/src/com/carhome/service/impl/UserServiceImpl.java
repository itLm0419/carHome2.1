package com.carhome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.carhome.dao.impl.UserDaoImpl;
import com.carhome.service.UserService;
import com.carhome.vo.User;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDaoImpl userDaoImpl;
	
	/**
	 * ÓÃ»§µÇÂ¼
	 */
	public User login(User user) {
		User u = userDaoImpl.returnUserByUserName(user);
		if(u != null){
			if(u.getPassword().equals(user.getPassword())){
				return u;
			}
		}
		return null;
	}

}
