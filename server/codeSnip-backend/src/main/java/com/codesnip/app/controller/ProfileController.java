package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.CustomerDto;
import com.codesnip.app.service.CustomerService;

@RestController
public class ProfileController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/profile")
	public CustomerDto getCustomerProfile(Authentication authentication) {

		CustomerDto customersDto = customerService.readByUsername(authentication.getName());
		return customersDto;

	}
}
