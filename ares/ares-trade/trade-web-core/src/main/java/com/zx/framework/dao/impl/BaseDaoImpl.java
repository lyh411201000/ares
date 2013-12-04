package com.zx.framework.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zx.framework.dao.BaseDao;
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	private String objName;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public BaseDaoImpl() {
		ParameterizedType pType = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
		objName = clazz.getSimpleName().substring(
				clazz.getSimpleName().indexOf(".") + 1);
	}
	public void delete(T model) {
		getSession().delete(model);
	}
	public List<T> findAll() {
		return getSession().createQuery("from " + objName).list();
	}
	public T getById(Long id) {
		return (T) getSession().createQuery(
				"from " + objName + " o where o.id=:id").setParameter("id", id)
				.uniqueResult();
	}
	public List<T> getByIds(Long[] ids) {
		return getSession().createQuery(
				"from " + objName + " o where o.id in ( :id )")
				.setParameterList("id", ids).list();
	}
	public void save(T entity) {
		getSession().save(entity);
	}
	public void update(T entity) {
		getSession().update(entity);
	}
}
