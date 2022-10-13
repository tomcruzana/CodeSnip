package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.CustomerDto;
import com.codesnip.app.service.CustomerService;

@RestController
public class RegisterController {

	@Autowired
	private Environment environment;

	@Autowired
	CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto newCustomerDto = null;
		ResponseEntity<?> response = null;
		try {
			newCustomerDto = customerService.createCustomer(customerDto);

			if (newCustomerDto != null) {
				response = new ResponseEntity<>(environment.getProperty("success.registration"), HttpStatus.CREATED);
				// log
			}
		} catch (Exception ex) {
			response = new ResponseEntity<>(environment.getProperty("error.generic"), HttpStatus.INTERNAL_SERVER_ERROR);
			// log
		}

		return response;

	}

}
