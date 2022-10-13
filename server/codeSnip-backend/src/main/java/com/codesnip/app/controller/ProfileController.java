package com.codesnip.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	@GetMapping("/profile")
	public String getCustomerProfile() {
		return "Here are the customer account details from the DB";
	}
}
