package com.codesnip.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.codesnip.app.dto.CustomerDto;

public interface CustomerService extends UserDetailsService {
	CustomerDto createCustomer(CustomerDto customerDto);

}
