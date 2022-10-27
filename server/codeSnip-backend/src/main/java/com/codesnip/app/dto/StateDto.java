package com.codesnip.app.dto;

import com.codesnip.app.entity.Country;

public class StateDto {

	private int id;

	private String name;

	private Country country;

	public StateDto() {
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
