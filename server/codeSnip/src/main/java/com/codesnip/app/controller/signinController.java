package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class signinController {

	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping(value = "/signin")
	public String getUserProfile() {
		String user = "testuser1";
		UserDetails userDetails = userDetailsService.loadUserByUsername(user);

		return userDetails.getUsername() + " successfuly signed in!";
	}
}
