package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.UserDto;
import com.codesnip.app.service.UserService;

@RestController
public class ProfileController {

	@Autowired
	private UserService userService;

	@GetMapping("/profile")
	public UserDto getUserProfile(Authentication authentication) {

		UserDto userDto = userService.readByEmail(authentication.getName());
		return userDto;

	}
}
