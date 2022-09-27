package com.codesnip.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class signinController {

	@GetMapping(value = "/signin")
	public String getUserProfile() {
		return "welcome";
	}
}
