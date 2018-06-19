package com.wu.service;

import java.util.List;

import javax.ejb.Local;

import com.wu.entities.User;

@Local
public interface UserService {
	void save(User user);

	void update(User user);

	void remove(long id);

	List<User> findAll();
}
