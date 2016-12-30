package com.carhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.carhome.vo.Product;
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> {
	//◊¢»ÎsessionFactory
			@Resource
			private SessionFactory sessionFactory ;
		
		/**
		 * ∑÷“≥œ‘ æ
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<Product> listEntityByPage(String kind,String name, Integer first, Integer max) {
			return sessionFactory.getCurrentSession().createQuery("from Product product where product.kind = ? and product.name=? order by product.typeNum")
																		.setParameter(0, kind)
																		.setParameter(1, name)
																		.setFirstResult(first)
																		.setMaxResults(max)
																		.list();
		}
		
		@SuppressWarnings("unchecked")
		public List<String> getKinds(String hql,Object...objects)
		{
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}

}
