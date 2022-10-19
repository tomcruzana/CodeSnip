package com.thomascruzana.codesnip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomascruzana.codesnip.dto.UserDto;
import com.thomascruzana.codesnip.service.UserService;

@RestController
public class UserLoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<UserDto> getUserProfile(Authentication authentication) {
		UserDto userDto = userService.readByEmail(authentication.getName());
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
}
