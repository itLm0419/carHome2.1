package com.carhome.dao.impl;

import org.springframework.stereotype.Repository;

import com.carhome.vo.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User>{
	/**
	 * �����û��������û�
	 */
	public User returnUserByUserName(User user){
		String hql = "from User user where user.userName = ?";
		User u = null;
		if( !this.findEntityByHQL(hql, user.getUserName()).isEmpty()){
			u = this.findEntityByHQL(hql, user.getUserName()).get(0);
		}
		return u;
	}
}
