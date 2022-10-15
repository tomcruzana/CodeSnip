package com.codesnip.app.dto;

import com.codesnip.app.entity.User;

public class AuthorityDto {
	private int id;

	private String name;

	private User user;

	public AuthorityDto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
