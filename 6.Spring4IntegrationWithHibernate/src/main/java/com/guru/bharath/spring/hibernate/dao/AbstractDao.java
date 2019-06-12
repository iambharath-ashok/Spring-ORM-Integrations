package com.guru.bharath.spring.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T, ID> {

	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public ID save(T entity) {
		return (ID) this.getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		return (T) this.getSession().merge(entity);
	}

	public void delete(T entity) {
		this.getSession().delete(entity);
	}
	
}
