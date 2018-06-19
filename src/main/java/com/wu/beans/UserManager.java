package com.wu.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wu.entities.User;
import com.wu.service.impl.UserServiceImpl;

@Named
@SessionScoped
public class UserManager implements Serializable {

	private User user;
	private List<User> userList;

	@EJB
	private UserServiceImpl userService;

	@Inject
	private ActionModifier actionModifier;

	@PostConstruct
	private void init() {
		user = new User();
	}

	public void reset() {
		userList = userService.findAll();
		user = new User();
	}

	public void execute() {
		String action = actionModifier.getActionType();
		switch (action) {
			case "Create":
				registerUser();
				break;
			case "Delete":
				removeUser();
				break;
			case "Update":
				updateUser();
				break;
		}
	}

	private void registerUser() {
		userService.save(user);
		reset();
	}

	private void updateUser() {
		userService.update(user);
		reset();
	}

	public void removeUser() {
		userService.remove(user.getId());
		reset();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		if (userList == null) {
			userList = userService.findAll();
		}
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}