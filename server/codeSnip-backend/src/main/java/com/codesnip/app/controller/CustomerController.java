package com.codesnip.app.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.CustomerDto;
import com.codesnip.app.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	private Environment environment;

	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto newCustomerDto = null;
		ResponseEntity<?> response = null;
		try {
			newCustomerDto = customerService.createCustomer(customerDto);

			if (newCustomerDto != null) {
				response = new ResponseEntity<>(environment.getProperty("success.registration"), HttpStatus.CREATED);
			}
		} catch (Exception ex) {
			response = new ResponseEntity<>(environment.getProperty("error.generic"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	@GetMapping("/profile")
	public String getCustomerProfile() {
		return "Here are the customer account details from the DB";
	}

}
