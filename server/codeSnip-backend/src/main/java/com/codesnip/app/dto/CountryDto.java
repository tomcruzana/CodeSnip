package com.codesnip.app.dto;

import java.util.List;

import com.codesnip.app.entity.State;

public class CountryDto {

	private int id;

	private String code;

	private String name;

	private List<State> states;

	public CountryDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}





}
