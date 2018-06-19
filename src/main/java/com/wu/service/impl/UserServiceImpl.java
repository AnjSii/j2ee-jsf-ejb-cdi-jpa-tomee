package com.wu.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wu.entities.User;
import com.wu.dao.UserDao;
import com.wu.service.UserService;


@Stateless
@LocalBean
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@EJB
	private UserDao userRepository;

	@Override
	public void save(User user) {
		userRepository.insert(user);
		LOGGER.debug("添加用户: " + user.getUserName());
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
		LOGGER.debug("修改用户 : " + user.getUserName());
	}

	@Override
	public void remove(long id) {
		userRepository.delete(id);
		LOGGER.debug("删除用户 : " + id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.select();
	}
}