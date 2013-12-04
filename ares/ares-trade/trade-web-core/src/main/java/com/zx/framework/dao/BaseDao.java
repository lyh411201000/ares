package com.zx.framework.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	public Session getSession();
	void save(T entity);
	void delete(T model);
	void update(T entity);
	T getById(Long id);
	List<T> getByIds(Long[] ids);
	List<T> findAll();
}