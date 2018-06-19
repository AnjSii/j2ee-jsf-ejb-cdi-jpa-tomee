package com.wu.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wu.core.domain.IdEntity;

@Entity
@Table(name = "users")
public class User extends IdEntity {

	private String userName;

	private String password;

	private int age;

	private String mobile;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
