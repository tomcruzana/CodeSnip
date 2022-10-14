package com.codesnip.app.service;

import com.codesnip.app.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto createCustomer(CustomerDto customerDto);

	public CustomerDto readByUsername(String username);

}
