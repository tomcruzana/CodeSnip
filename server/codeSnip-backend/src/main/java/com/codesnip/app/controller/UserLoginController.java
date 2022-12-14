package com.codesnip.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnip.app.dto.UserDto;
import com.codesnip.app.service.UserService;

// user login controller
@RestController
public class UserLoginController {

	@Autowired
	private UserService userService;

	// fetches username (email) and validates if the user is registered
	@GetMapping("/user")
	public ResponseEntity<?> getUserProfile(Authentication authentication) {
		UserDto userDto = userService.readByEmail(authentication.getName());

		// check if user has not verified email or disabled
		if (!userDto.isEnabled()) {
			return new ResponseEntity<>("Please verify your email", HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<>(userDto, HttpStatus.OK);

	}
}
