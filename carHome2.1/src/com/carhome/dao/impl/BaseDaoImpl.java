package com.carhome.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import com.carhome.dao.BaseDao;

/**
 * �����daoʵ��,ר�����ڼ̳�
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	//ע��sessionFactory
	@Resource
	private SessionFactory sessionFactory ;
	
	private Class<T> clazz ;
	
	public BaseDaoImpl(){
		//�õ����ͻ�����
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public void saveEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void saveOrUpdateEntity(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public void deleteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	/**
	 * ����HQL��������������
	 */
	public void batchEntityByHQL(String hql, Object... objects) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		q.executeUpdate();
	}
	
	//ִ��ԭ����sql���
		public void executeSQL(String sql,Object...objects){
			SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
			for(int i = 0 ; i < objects.length ; i ++){
				q.setParameter(i, objects[i]);
			}
			q.executeUpdate();
		}

	public T loadEntity(Integer id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	public T getEntity(Integer id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		//System.out.println(sessionFactory);
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
	
	//��ֵ����,ȷ����ѯ�������ֻ��һ����¼
	public Object uniqueResult(String hql,Object...objects){
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}
	
	//ִ��ԭ����sql��ѯ
	public List executeSQLQuery(Class clazz,String sql,Object...objects){
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		//���ʵ����
		if(clazz != null){
			q.addEntity(clazz);
		}
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}
	/**
	 * ��ҳ��ѯ
	 * @param clazz
	 * @param sql
	 * @param first
	 * @param max
	 * @return
	 */
	public List executeSQLQuery(Class clazz,String sql,Integer first,Integer max){
		System.out.println("first="+first);
		System.out.println("first="+max);
		System.out.println(sql);
		SQLQuery q = (SQLQuery) sessionFactory.getCurrentSession().createSQLQuery(sql)
										.setMaxResults(max)
										.setFirstResult(first);
		//���ʵ����
		if(clazz != null){
			q.addEntity(clazz);
		}
		return q.list();
	}
	
	//����һ�������sql��ѯ
	public Object executeSQLQueryObject(Class clazz,String sql,Object...objects){
		SQLQuery q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		//���ʵ����
		if(clazz != null){
			q.addEntity(clazz);
		}
		for(int i = 0 ; i < objects.length ; i ++){
			q.setParameter(i, objects[i]);
		}
		return q.uniqueResult();
	}
}
