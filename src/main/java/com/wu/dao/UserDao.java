package com.wu.dao;

import javax.ejb.Stateless;

import com.wu.entities.User;
import com.wu.core.dao.impl.GenericDAOImpl;


@Stateless
public class UserDao extends GenericDAOImpl<User> {

	public UserDao() {
		super(User.class);
	}
}
