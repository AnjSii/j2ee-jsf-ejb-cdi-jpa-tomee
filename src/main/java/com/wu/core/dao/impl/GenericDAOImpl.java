package com.wu.core.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.wu.core.dao.GenericDAO;

@Stateless
public class GenericDAOImpl<T> implements GenericDAO<T> {

	@PersistenceContext(name = "db-connection")
	protected EntityManager entityManager;

	private Class<T> entityClass;

	public GenericDAOImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public GenericDAOImpl() {
	}

	public void insert(T t) {
		entityManager.persist(t);
	}

	public void update(T t) {
		entityManager.merge(t);
	}

	public void delete(long id) {
		entityManager.createQuery("DELETE " + entityClass.getName() + " u where u.id=:x")
				.setParameter("x", id).executeUpdate();
	}

	public void delete(T t) {
		entityManager.remove(t);
	}

	public T select(long id) {
		return entityManager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> select() {
		return entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
	}
}
