package com.wu.core.dao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GenericDAO<T> {
	void insert(T t);

	void update(T t);

	void delete(long id);

	void delete(T t);

	T select(long id);

	List<T> select();
}
